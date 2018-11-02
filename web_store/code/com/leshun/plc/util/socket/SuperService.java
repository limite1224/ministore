package com.leshun.plc.util.socket;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sls.core.common.CommonUtil;
import com.sls.core.socket.Head;
import com.sls.core.socket.SocketClient;
import com.sls.core.socket.SocketDTO;
import com.sls.core.socket.TransmissionCode;

public abstract class SuperService {
	protected static final Logger log = Logger.getLogger(SuperService.class);
	private static final Map<String, PrefixInfo> map = new ConcurrentHashMap<String, PrefixInfo>();
	private static final ExecutorService EXECUTOR_SERVICE = Executors
			.newFixedThreadPool(200);

	/**
	 * 向服务器发送不需要body的请求,服务代码必须是六位
	 * 
	 * @param head
	 * @return SocketDTO
	 */
	protected final SocketDTO send(Head head) {
		SocketDTO dto = new SocketDTO();
		dto.setHead(head);
		SocketDTO socketDTO = null;
		try {
			// 参数不正确
			if (head == null || head.getServiceCode() == null
					|| head.getServiceCode().trim().length() != 6)
				throw new IllegalArgumentException();
			socketDTO = this.send(head, null);
			if (socketDTO == null || socketDTO.getHead() == null)
				throw new NullPointerException();
		} catch (Exception e) {
			log.warn("处理出错", e);
			if (socketDTO == null)
				socketDTO = new SocketDTO();
			if (head == null)
				head = new Head();
			head.setResponseCode(TransmissionCode.ERROR.getCode());
			head.setResponseMessage(TransmissionCode.ERROR.getMessage());
			socketDTO.setHead(head);
		}
		return socketDTO;
	}

	/**
	 * 向服务器发送请求,服务代码必须是六位
	 * 
	 * @param SocketDTO
	 * @return SocketDTO
	 */

	@SuppressWarnings("unused")
	private final SocketDTO send(SocketDTO dto) {
		SocketDTO socketDTO = null;
		try {
			// 参数不正确
			if (dto == null || dto.getHead() == null
					|| dto.getHead().getServiceCode() == null
					|| dto.getHead().getServiceCode().trim().length() != 6)
				throw new IllegalArgumentException();
			socketDTO = this.send(dto.getHead(), dto.getBody());
			if (socketDTO == null || socketDTO.getHead() == null)
				throw new NullPointerException();
		} catch (Exception e) {
			log.warn("处理出错", e);
			if (socketDTO == null)
				socketDTO = new SocketDTO();
			Head head = new Head();
			head.setResponseCode(TransmissionCode.ERROR.getCode());
			head.setResponseMessage(TransmissionCode.ERROR.getMessage());
			socketDTO.setHead(head);
		}
		return socketDTO;
	}

	/**
	 * 向服务器发送请求
	 * 
	 * @param head
	 * @param body
	 *            未gson格式转换的对象，可以是String也可以使其他对象
	 * @return SocketDTO
	 */
	protected final SocketDTO send(Head head, Object body) {
		Gson gson = CommonUtil.gson();
		SocketDTO dto = new SocketDTO();
		dto.setHead(head);
		SocketDTO socketDTO = null;
		try {
			// 参数不正确
			if (head == null || head.getServiceCode() == null
					|| head.getServiceCode().trim().length() != 6)
				throw new IllegalArgumentException();
			Map<String, PrefixInfo> prefixMap = initSocketServiceInfo();
			String servicePrefix = head.getServiceCode().substring(0, 2);
			if (head.getRequestId() == null
					|| head.getRequestId().trim().length() == 0)
				head.setRequestId(UUID.randomUUID().toString());
			PrefixInfo prefixInfo = prefixMap.get(servicePrefix);
			// 获取默认的ip和port
			if (prefixInfo == null)
				prefixInfo = prefixMap.get("*");
			dto.setBody(null);
			String message = gson.toJson(dto);
			JsonParser parser = new JsonParser();
			JsonObject o = parser.parse(message).getAsJsonObject();
			if (body != null) {
				o.add("body", parser.parse(gson.toJson(body)));
				message = o.toString();
			}
			message = this.send(message, prefixInfo.getIp(),
					prefixInfo.getPort());
			o = parser.parse(message).getAsJsonObject();
			JsonElement headStr = o.get("head");
			socketDTO = new SocketDTO();
			socketDTO.setHead(gson.fromJson(headStr, Head.class));
			if (o.get("body") != null)
				socketDTO.setBody(o.get("body").toString());
			if (socketDTO == null || socketDTO.getHead() == null)
				throw new NullPointerException();
		} catch (Exception e) {
			log.warn("处理出错", e);
			if (socketDTO == null)
				socketDTO = new SocketDTO();
			if (head == null)
				head = new Head();
			head.setResponseCode(TransmissionCode.ERROR.getCode());
			head.setResponseMessage(TransmissionCode.ERROR.getMessage());
			socketDTO.setHead(head);
		}
		return socketDTO;
	}

	/**
	 * 向服务器发送请求
	 * 
	 * @param message格式转换的socketDTO的字符串
	 *            ，返回也是socketDTO转换的字符串
	 * @return
	 */
	private final String send(String message, String ip, int port) {
		try {
			if (StringUtils.isBlank(ip) || port <= 0)
				throw new IllegalArgumentException();
			Future<String> future = EXECUTOR_SERVICE.submit(new SocketClient(
					ip, port, message));
			return future.get();
		} catch (Exception e) {
			log.warn("处理出错", e);
			SocketDTO dto = new SocketDTO();
			Head head = new Head();
			if (e.getMessage() != null
					&& e.getMessage().indexOf("Failed to get the session") >= 0) {
				head.setResponseCode(TransmissionCode.CONNECT_TIME_OUT_ERROR
						.getCode());
				head.setResponseMessage(TransmissionCode.CONNECT_TIME_OUT_ERROR
						.getMessage());
			} else {
				head.setResponseCode(TransmissionCode.ERROR.getCode());
				head.setResponseMessage(TransmissionCode.ERROR.getMessage());
			}
			dto.setHead(head);
			return CommonUtil.gson().toJson(dto);
		}
	}

	/**
	 * 错误的话系统无法启动
	 * 
	 * @return
	 */
	private static Properties initProperties() {
		Properties p = new Properties();
		try {
			p.load(SuperService.class.getClassLoader().getResourceAsStream(
					"socket.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	private static Map<String, PrefixInfo> initSocketServiceInfo()
			throws Exception {
		if (map == null || map.isEmpty()) {
			Properties p = initProperties();
			String tmpprefix = "code.prefix";
			p.put("default.server.socket." + tmpprefix, "*");
			Iterator<Object> it = p.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next().toString();
				Matcher matcher = Pattern.compile("\\w*" + tmpprefix,
						Pattern.CASE_INSENSITIVE).matcher(key);
				while (matcher.find()) {
					PrefixInfo prefixInfo = new PrefixInfo();
					prefixInfo.setPrefix(p.getProperty(key));
					String tma = matcher.replaceAll("");
					prefixInfo.setIp(p.getProperty(tma + "ip"));
					try {
						prefixInfo.setPort(Integer.parseInt(p.getProperty(tma
								+ "port")));
					} catch (Exception e) {
					}
					map.put(prefixInfo.getPrefix(), prefixInfo);
				}
			}
			if (map != null && !map.isEmpty()) {
				Iterator<Entry<String, PrefixInfo>> st = map.entrySet()
						.iterator();
				while (st.hasNext()) {
					Entry<String, PrefixInfo> entry = st.next();
					PrefixInfo perfix = entry.getValue();
					System.err.println(perfix.getIp() + ":" + perfix.getPort()
							+ ":" + perfix.getPrefix());
				}
			}
		}
		return map;
	}
}

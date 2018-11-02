package com.leshun.plc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sls.core.socket.OrderIdServer;
import com.sls.core.socket.ServerDisponseException;

@Service("IDGenerater")
public class IDGenerater {
	private String orderIp;
	private String orderPort;

	private static Logger log = Logger.getLogger(IDGenerater.class);
	private static IDGenerater idGene;

	private IDGenerater() {
	}

	public static synchronized IDGenerater getInstance() {
		if (idGene == null) {
			idGene = new IDGenerater();
			idGene.orderPort = PropertiesUtil.getValue("order.port",
					"orderId.properties");
			idGene.orderIp = PropertiesUtil.getValue("order.ip",
					"orderId.properties");
		}
		return idGene;
	}

	public String getOrderNo(String... classNames) {
		String name = "IDGenerater";
		if (classNames != null && classNames.length > 0) {
			name = classNames[0];
		}

		String orderId = null;
		for (int s = 0; s < 10; s++) {
			if (orderId == null) {
				try {
					int port = 3838;
					try {
						port = Integer.parseInt(orderPort);
					} catch (Exception e) {
						log.info("获取订单号出现异常", e);
						throw new ServerDisponseException("9999", "获取订单号异常");
					}
					orderId = OrderIdServer.sendMessage(orderIp, port, name);
					if (orderId == null)
						Thread.sleep(200);
				} catch (Exception e) {
					log.error(e);
					throw new ServerDisponseException("9999", "获取订单号异常");
				}
			} else
				break;
		}

		return orderId;
	}

	private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public synchronized static String createFlowNo(String fileName,
			String servNode, int length) throws Exception {
		if (length <= 24)
			length = 24;
		File file = new File(fileName);
		if (file != null && !file.exists()) {
			file.createNewFile();
		}
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String txt = bf.readLine();
		Integer oldOrderId = null;
		String orderIds = "0";
		String today = SIMPLEDATEFORMAT.format(new Date());
		try {
			if (txt != null
					&& txt.length() > 18
					&& today.substring(0, 8).equalsIgnoreCase(
							txt.substring(0, 8))) {
				orderIds = txt.substring(18, txt.length());
				oldOrderId = Integer.parseInt(orderIds);
				orderIds = String.valueOf(++oldOrderId);
			}
		} catch (Exception e) {
		}
		StringBuffer result = new StringBuffer();
		result.append(today);
		result.append(servNode);
		int remainLength = length - today.length() - servNode.length()
				- orderIds.length();
		if (remainLength > 0) {
			for (int r = 0; r < remainLength; r++) {
				result.append("0");
			}
		}
		result.append(orderIds);
		FileWriter fw = new FileWriter(file);
		fw.write(result.toString());
		fw.flush();
		fw.close();
		bf.close();
		return result.toString();
	}
}

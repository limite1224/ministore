package com.leshun.plc.util.wechat.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.leshun.plc.util.wechat.bean.pay.PayResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * Created by caiyida on 2017/4/7.
 */
public class XmlUtils {

	/**
	 * java对象转换为xml文件
	 *
	 * @return xml文件的String
	 * @throws JAXBException
	 */
	public static String beanToXml(Object obj) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			return writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * xml文件配置转换为对象
	 *
	 * @return java对象
	 */
	public static Object xmlToBean(String xml, Class<?> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static XStream getXStream() {
		XStream stream = new XStream(new XppDriver(new NoNameCoder()) {

			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// 对所有xml节点的转换都增加CDATA标记
					boolean cdata = true;

					@Override
					@SuppressWarnings("rawtypes")
					public void startNode(String name, Class clazz) {
						super.startNode(name, clazz);
					}

					@Override
					public String encodeNode(String name) {
						return name;
					}

					@Override
					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});

		return stream;
	}

	public static void main(String[] args) {
		PayResponse payResponse = new PayResponse();
		payResponse.setReturnCode("SUCCESS");
		payResponse.setReturnMsg("OK");

		System.out.println(beanToXml(payResponse));
	}

}

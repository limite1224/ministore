package com.leshun.plc.util.wechat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	private static SSLConnectionSocketFactory socketFactory;

	public static String httpGetRequest(String url) {
		RequestConfig config = RequestConfig.custom()
				.setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(config).build();
		HttpGet get = new HttpGet();
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpPostRequest(String url,
			Map<String, String> params) {
		RequestConfig config = RequestConfig.custom()
				.setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(config).build();
		HttpPost post = new HttpPost(url);

		try {
			List<NameValuePair> values = new ArrayList<NameValuePair>();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					BasicNameValuePair pair = new BasicNameValuePair(
							entry.getKey(), entry.getValue());
					values.add(pair);
				}
			}

			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(values);
			post.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpPostRequestString(String url, String outputStr,
			ContentType contentType) {
		RequestConfig config = RequestConfig.custom()
				.setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultRequestConfig(config).build();
		HttpPost post = new HttpPost(url);

		try {
			post.addHeader("Content-Type", contentType.getMimeType());

			StringEntity myEntity = new StringEntity(outputStr, "UTF-8");
			post.setEntity(myEntity);

			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();

				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsGetRequest(String url) {
		enableSSL();
		HttpGet get = new HttpGet(url);
		try {
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)
					.setExpectContinueEnabled(true)
					.setTargetPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
					.setProxyPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.BASIC))
					.build();
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", socketFactory).build();
			PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
					socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom()
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(defaultRequestConfig).build();
			CloseableHttpResponse response = httpClient.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsPostRequest(String url,
			Map<String, String> params) {
		enableSSL();
		try {
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)
					.setExpectContinueEnabled(true)
					.setTargetPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
					.setProxyPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.BASIC))
					.build();
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", socketFactory).build();
			PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
					socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom()
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(defaultRequestConfig).build();

			List<NameValuePair> values = new ArrayList<NameValuePair>();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					BasicNameValuePair pair = new BasicNameValuePair(
							entry.getKey(), entry.getValue());
					values.add(pair);
				}
			}

			HttpPost post = new HttpPost(url);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(values,
					"UTF-8");
			post.setEntity(entity);
			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsPostRequestString(String url, String outputStr,
			ContentType contentType) {
		enableSSL();
		try {
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)
					.setExpectContinueEnabled(true)
					.setTargetPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
					.setProxyPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.BASIC))
					.build();
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", socketFactory).build();
			PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
					socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom()
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(defaultRequestConfig).build();

			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", contentType.getMimeType());

			StringEntity myEntity = new StringEntity(outputStr, "UTF-8");
			httpPost.setEntity(myEntity);

			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsPostMultipart(String url,
			Map<String, String> params, File file) {
		enableSSL();
		try {
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)
					.setExpectContinueEnabled(true)
					.setTargetPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
					.setProxyPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.BASIC))
					.build();
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", socketFactory).build();
			PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
					socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom()
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(defaultRequestConfig).build();
			HttpPost post = new HttpPost(url);

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					builder.addTextBody(entry.getKey(), entry.getValue());// 增加文本内容
				}
			}

			builder.addBinaryBody("form", file);// 增加字节内容，第二个参数可以是File,byte[],InputStream
			post.setEntity(builder.build());

			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 该方法无效
	public static String httpsPostMultipart(String url,
			Map<String, String> params, InputStream is) {
		enableSSL();
		try {
			RequestConfig defaultRequestConfig = RequestConfig.custom()
					.setCookieSpec(CookieSpecs.STANDARD_STRICT)
					.setExpectContinueEnabled(true)
					.setTargetPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
					.setProxyPreferredAuthSchemes(
							Arrays.asList(AuthSchemes.BASIC))
					.build();
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", socketFactory).build();
			PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
					socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom()
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(defaultRequestConfig).build();
			HttpPost post = new HttpPost(url);

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					builder.addTextBody(entry.getKey(), entry.getValue());// 增加文本内容
				}
			}

			builder.addBinaryBody("form", is);// 增加字节内容，第二个参数可以是File,byte[],InputStream
			post.setEntity(builder.build());

			CloseableHttpResponse response = httpClient.execute(post);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity respEntity = response.getEntity();
				String responseContent = EntityUtils.toString(respEntity,
						"UTF-8");
				return responseContent;
			}
			is.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsPostWithCert(String url,
			Map<String, String> params, String certPath, String password) {
		Map<String, String> map = null;
		String text = "";

		KeyStore keyStore;
		try {
			keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(certPath);
			try {
				keyStore.load(instream, password.toCharArray());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				instream.close();
			}

			SSLContext sslcontext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, password.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext);

			/*
			 * SSLConnectionSocketFactory sslsf = new
			 * SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
			 * null,
			 * SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			 */
			CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(sslsf).build();

			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "text/xml");

			List<NameValuePair> values = new ArrayList<NameValuePair>();
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					BasicNameValuePair pair = new BasicNameValuePair(
							entry.getKey(), entry.getValue());
					values.add(pair);
				}
			}
			UrlEncodedFormEntity myEntity = new UrlEncodedFormEntity(values,
					"UTF-8");
			httpPost.setEntity(myEntity);

			CloseableHttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				text = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);

			response.close();
			httpClient.close();

			return text;
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String httpsPostWithCert(String url, String outputStr,
			ContentType contentType, String certPath, String password) {
		Map<String, String> map = null;
		String text = "";

		KeyStore keyStore;
		try {
			keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(certPath);
			try {
				keyStore.load(instream, password.toCharArray());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				instream.close();
			}

			SSLContext sslcontext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, password.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext);

			/*
			 * SSLConnectionSocketFactory sslsf = new
			 * SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
			 * null,
			 * SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			 */
			CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(sslsf).build();

			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", contentType.getMimeType());

			StringEntity myEntity = new StringEntity(outputStr, "UTF-8");
			httpPost.setEntity(myEntity);

			CloseableHttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				text = EntityUtils.toString(entity, "utf-8");
			}
			EntityUtils.consume(entity);

			response.close();
			httpClient.close();

			return text;
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static TrustManager manager = new X509TrustManager() {

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {

		}

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {

		}
	};

	private static void enableSSL() {
		try {
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new TrustManager[] { manager }, null);
			socketFactory = new SSLConnectionSocketFactory(context,
					NoopHostnameVerifier.INSTANCE);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

}

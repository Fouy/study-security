package com.way361.security.chapter11_3;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Test;

/**
 * 11-10 HTTPS测试
 * @author huge
 *
 */
public class HTTPSCoderTest {

	/** 密钥库/信任库密码 */
	private String password = "123456";

	/** 密钥库文件路径 */
	private String keyStorePath = "d:/way361.keystore";

	/** 信任库文件路径 */
	private String trustStorePath = "d:/way361.keystore";

	/** 访问地址 */
	private String httpsUrl = "https://www.way361.com/ssl/";

	/**
	 * HTTPS验证
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		// 建立HTTPS链接
		URL url = new URL(httpsUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		// conn.setRequestMethod(method);
		// 打开输入输出流
		conn.setDoInput(true);
		// conn.setDoOutput(true);

		// 为HttpsURLConnection配置SSLSocketFactory
		HTTPSCoder.configSSLSocketFactory(conn, password, keyStorePath, trustStorePath);

		// 鉴别内容长度
		int length = conn.getContentLength();
		byte[] data = null;

		// 如果内容长度为-1，则放弃解析
		if (length != -1) {
			DataInputStream dis = new DataInputStream(conn.getInputStream());
			data = new byte[length];
			dis.readFully(data);
			dis.close();
			System.err.println(new String(data));
		}
		conn.disconnect();
		// 验证
		assertNotNull(data);
	}
}

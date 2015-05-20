package com.way361.security.chapter3_6;

import java.io.FileInputStream;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.junit.Test;

/**
 * 3.6 javax.net.ssl 包详解
 * @author huge
 *
 */
public class SSLTest {
	
	/**
	 * 3-26 构建秘钥管理工厂
	 * @throws Exception 
	 */
	@Test
	public void testKeyManagerFactory() throws Exception {
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		FileInputStream inputStream = new FileInputStream("D:/x.keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(inputStream, "password".toCharArray());
		inputStream.close();
		keyManagerFactory.init(ks, "password".toCharArray());
	}
	
	/**
	 * 3-27 构建信任管理工厂
	 * @throws Exception 
	 */
	@Test
	public void testTrustManagerFactory() throws Exception {
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
		FileInputStream inputStream = new FileInputStream("D:/x.keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(inputStream, "password".toCharArray());
		inputStream.close();
		trustManagerFactory.init(ks);
	}
	
	/**
	 * 3-28 构建SSLSocketFactory
	 * @param keyStorePath
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
		FileInputStream inputStream = new FileInputStream(keyStorePath);
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(inputStream, "passoword".toCharArray());
		inputStream.close();
		return ks;
	}
	
	/**
	 * 获得SSLSocketFactory
	 * @param password 密码
	 * @param keyStorePath 秘钥库路径
	 * @param trustKeyStorePath 信任库路径
	 * @return
	 * @throws Exception
	 */
	public static SSLSocketFactory getSSLSocketFactory(String password, 
			String keyStorePath, String trustKeyStorePath) throws Exception {
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		KeyStore keyStore = getKeyStore(keyStorePath, password);
		keyManagerFactory.init(keyStore, password.toCharArray());
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
		KeyStore trustKeyStore = getKeyStore(trustKeyStorePath, password);
		trustManagerFactory.init(trustKeyStore);
		SSLContext ctx = SSLContext.getInstance("SSL");
		ctx.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
		SSLSocketFactory sf = ctx.getSocketFactory();
		return sf;
	}
	
	/**
	 * 3-29 构建HTTPS
	 * @throws Exception 
	 */
	@Test
	public void testHTTPS() throws Exception {
		URL url = new URL("https://www.baidu.com");
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
//		configSSLSocketFactory(conn, "password", "D:/x.keystore");
	}

}

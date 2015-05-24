package com.way361.security.chapter6_5;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 6-19 HmacRipeMD系列算法实现
 * @author huge
 *
 */
public abstract class HmacRipeMDCoder {

	/**
	 * 初始化HmacRipeMD128 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacRipeMD128Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacRipeMD128");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacRipeMD128 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacRipeMD128(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = new SecretKeySpec(key, "HmacRipeMD128");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * HmacRipeMD128Hex 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encodeHmacRipeMD128Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacRipeMD128(data, key);
		return new String(Hex.encode(b));
	}
	
	/**
	 * 初始化HmacRipeMD160 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacRipeMD160Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacRipeMD160");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacRipeMD160 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacRipeMD160(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = new SecretKeySpec(key, "HmacRipeMD160");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * HmacRipeMD160Hex 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encodeHmacRipeMD160Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacRipeMD160(data, key);
		return new String(Hex.encode(b));
	}
	
	
}

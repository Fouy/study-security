package com.way361.security.chapter6_4;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 6-13 MAC算法实现1
 * @author huge
 *
 */
public abstract class MACCoder {

	/**
	 * 初始化HmacMD5 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacMD5Key() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacMD5 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD5(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA1 Key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHAKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacSHA1 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA256 Key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA256Key() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacSHA256 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA256(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA384 Key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA384Key() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA384");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacSHA384 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA384(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA384");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * 初始化HmacSHA512 Key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA512Key() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacSHA512 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA512(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA512");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
}

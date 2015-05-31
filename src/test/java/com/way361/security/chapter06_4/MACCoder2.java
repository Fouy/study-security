package com.way361.security.chapter06_4;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 6-15 MAC算法实现2
 * @author huge
 *
 */
public abstract class MACCoder2 {

	/**
	 * 初始化HmacMD2 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacMD2Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD2");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacMD2 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD2(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD2");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * HmacMD2Hex 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encodeHmacMD2Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacMD2(data, key);
		return new String(Hex.encode(b));
	}
	
	/**
	 * 初始化HmacMD4 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacMD4Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD4");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacMD4 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD4(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD4");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * HmacMD4Hex 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encodeHmacMD4Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacMD4(data, key);
		return new String(Hex.encode(b));
	}
	
	/**
	 * 初始化HmacSHA224 key
	 * @return
	 * @throws Exception
	 */
	public static byte[] initHmacSHA224Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA224");
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}
	
	/**
	 * HmacSHA224 消息摘要
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA224(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA224");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(data);
	}
	
	/**
	 * HmacSHA224Hex 消息摘要
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encodeHmacSHA224Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacSHA224(data, key);
		return new String(Hex.encode(b));
	}
	
	
}

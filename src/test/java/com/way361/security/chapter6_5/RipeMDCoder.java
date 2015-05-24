package com.way361.security.chapter6_5;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 	6-17 RipeMD消息摘要算法实现
 * @author huge
 *
 */
public abstract class RipeMDCoder {

	/**
	 * Ripe128消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeRipeMD128(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD128");
		return md.digest(data);
	}
	
	/**
	 * Ripe128Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeRipeMD128Hex(byte[] data) throws Exception {
		byte[] b = encodeRipeMD128(data);
		return new String(Hex.encode(b));
	}
	
	/**
	 * Ripe160消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeRipeMD160(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD160");
		return md.digest(data);
	}
	
	/**
	 * Ripe160Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeRipeMD160Hex(byte[] data) throws Exception {
		byte[] b = encodeRipeMD160(data);
		return new String(Hex.encode(b));
	}
	
	/**
	 * Ripe256消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeRipeMD256(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD256");
		return md.digest(data);
	}
	
	/**
	 * Ripe256Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeRipeMD256Hex(byte[] data) throws Exception {
		byte[] b = encodeRipeMD256(data);
		return new String(Hex.encode(b));
	}
	
	/**
	 * Ripe320消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeRipeMD320(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("RipeMD320");
		return md.digest(data);
	}
	
	/**
	 * Ripe320Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeRipeMD320Hex(byte[] data) throws Exception {
		byte[] b = encodeRipeMD320(data);
		return new String(Hex.encode(b));
	}
	
	
}

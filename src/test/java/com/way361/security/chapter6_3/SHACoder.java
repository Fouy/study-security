package com.way361.security.chapter6_3;

import java.security.MessageDigest;

/**
 * 6-7 SHA算法实现
 * @author huge
 *
 */
public abstract class SHACoder {

	/**
	 * SHA-1 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		return md.digest(data);
	}
	
	/**
	 * SHA-256 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(data);
	}
	
	/**
	 * SHA-384 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-384");
		return md.digest(data);
	}
	
	/**
	 * SHA-512 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		return md.digest(data);
	}
	
}

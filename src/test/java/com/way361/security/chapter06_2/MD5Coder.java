package com.way361.security.chapter06_2;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 6-5 MD5算法实现
 * @author huge
 *
 */
public abstract class MD5Coder {

	/**
	 * MD5消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception {
		return DigestUtils.md5(data);
	}
	
	/**
	 * MD5Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeMD5Hex(String data) throws Exception {
		return DigestUtils.md5Hex(data);
	}
}

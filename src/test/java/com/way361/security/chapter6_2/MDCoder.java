package com.way361.security.chapter6_2;

import java.security.MessageDigest;

/**
 * 6-1 MD2和MD5算法实现
 * @author xuefeihu
 *
 */
public abstract class MDCoder {

	/**
	 * MD2 消息摘要
	 * @param data 待处理数据
	 * @return 
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD2");
		return md.digest(data);
	}
	
	/**
	 * MD5 消息摘要
	 * @param data 待摘要数据
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		return md.digest(data);
	}
}

package com.way361.security.chapter5_6;

import org.bouncycastle.util.encoders.Base64;

/**
 * 5-1 Base64 组件
 * @author huge
 *
 */
public abstract class Base64Coder {
	
	public static final String ENCODING = "UTF-8";
	
	/**
	 * Base64编码
	 * @param data 待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		byte[] b = Base64.encode(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
	/**
	 * Base64解码
	 * @param data 待解数据
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		byte[] b = Base64.decode(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
	
}

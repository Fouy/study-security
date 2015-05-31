package com.way361.security.chapter06_2;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * MD4 算法实现
 * @author huge
 *
 */
public abstract class MD4Coder {

	/**
	 * MD4 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeMD4(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("MD4");
		return md.digest(data);
	}
	
	/**
	 * MD4 消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeMD4Hex(byte[] data) throws Exception {
		byte[] b = encodeMD4(data);
		return new String(Hex.encode(b));
	}
	
}

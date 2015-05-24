package com.way361.security.chapter6_3;

import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 6-9 SHA224 算法实现
 * @author huge
 *
 */
public abstract class SHA224Coder {

	/**
	 * SHA224消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encodeSHA224(byte[] data) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("SHA-224");
		return md.digest(data);
	}
	
	/**
	 * SHA224Hex消息摘要
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encodeSHA224Hex(byte[] data) throws Exception {
		byte[] b = encodeSHA224(data);
		return new String(Hex.encode(b));
	}
	
	
	
	
}

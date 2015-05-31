package com.way361.security.chapter07_7;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 7-13 摘要/验证
 * @author xuefeihu
 *
 */
public abstract class AESCoder {

	/**
	 * 秘钥算法
	 */
	public static final String ALGORITHM = "AES";
	
	/**
	 * 转换秘钥
	 * @param key 二进制秘钥
	 * @return Key 秘钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		return secretKey;
	}
	
	/**
	 * 解密
	 * @param data 待解密数据
	 * @param key 秘钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String key) throws Exception {
		return decrypt(data, getKey(key));
	}
	
	/**
	 * 解密
	 * @param data 待解密数据
	 * @param key 秘钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	/**
	 * 加密
	 * @param data 待加密数据
	 * @param key 秘钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String key) throws Exception {
		return encrypt(data, getKey(key));
	}
	
	/**
	 * 加密
	 * @param data 待加密数据
	 * @param key 秘钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	/**
	 * 获取秘钥
	 * @param key 秘钥
	 * @return byte[] 秘钥
	 * @throws Exception
	 */
	public static byte[] getKey(String key) throws Exception {
		return Base64.decodeBase64(key);
	}
	
	/**
	 * 摘要处理
	 * @param data 待摘要数据
	 * @return String 摘要字符串
	 */
	public static String shaHex(byte[] data) {
		return DigestUtils.md5Hex(data);
	}
	
	/**
	 * 验证
	 * @param data 带摘要数据
	 * @param messageDigest 摘要字符串
	 * @return Boolean 验证结果
	 */
	public static boolean validate(byte[] data, String messageDigest) {
		return messageDigest.equals(shaHex(data));
	}
	
}

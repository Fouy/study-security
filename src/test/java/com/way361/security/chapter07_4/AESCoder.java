package com.way361.security.chapter07_4;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 7-5 AES算法实现
 * @author xuefeihu
 *
 */
public abstract class AESCoder {

	/**
	 * 秘钥算法
	 */
	public static final String KEY_ALGORITHM = "AES";
	
	/**
	 * 加密/解密算法 / 工作模式 / 填充方式
	 * java6支持PKCS5Padding填充方式
	 * Bouncy Castle支持PKCS7Padding填充方式
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	/**
	 * 转换秘钥
	 * @param key 二进制秘钥
	 * @return Key 秘钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
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
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
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
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}
	
	/**
	 * 生成秘钥
	 * @return 二进制秘钥
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(256);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}
	
}

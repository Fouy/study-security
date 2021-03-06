package com.way361.security.chapter07_2;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 7-1 DES算法实现
 * @author huge
 *
 */
public abstract class DESCoder {

	/**
	 * 秘钥算法
	 * Java6只支持56位秘钥
	 * Bouncy Castle支持64位秘钥
	 */
	public static final String KEY_ALGORITHM = "DES";
	
	/**
	 * 加密/解密算法 / 工作模式 / 填充方式
	 */
	public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	
	/**
	 * 转换秘钥
	 * @param key 二进制秘钥
	 * @return Key 秘钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}
	
	/**
	 * 解密
	 * @param data 待解密数据
	 * @param key 秘钥
	 * @return byte[] 解密数据
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
	 * @return byte[] 加密数据
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
	 * Java6只支持56位秘钥
	 * Bouncy castle 支持64位秘钥
	 * @return byte[] 二进制秘钥
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception {
//		KeyGenerator.getInstance(CIPHER_ALGORITHM); 替换为：
//		KeyGenerator.getInstance(CIPHER_ALGORITHM, "BC");
		
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(56);//替换 kg.init(64);
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}
	
	
}

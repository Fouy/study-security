package com.way361.security.chapter7_6;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * 7-9 PBE算法实现
 * @author xuefeihu
 *
 */
public abstract class PBECoder {

	/**
	 * JAVA6支持以下任意一种算法
	 * PBEWithMD5AndDES
	 * PBEWithMD5AndTripleDES
	 * PBEWithSHA1AndDESede
	 * PBEWithSHA1AndRC2_40
	 * PBKDF2WithHmacSHA1
	 */
	public static final String ALGORITHM = "PBEWithMD5AndDES";
	
	/**
	 * 迭代次数
	 */
	public static final int ITERATION_COUNT = 100;
	
	/**
	 * 盐初始化--长度必须为8字节
	 * @return byte[] 盐
	 * @throws Exception
	 */
	public static byte[] initSalt() throws Exception {
		SecureRandom random = new SecureRandom();
		return random.generateSeed(8);
	}
	
	/**
	 * 转换秘钥
	 * @param password 密码
	 * @return Key 秘钥
	 * @throws Exception
	 */
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return secretKey;
	}
	
	/**
	 * 加密
	 * @param data 数据
	 * @param password 密码
	 * @param salt 盐
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String password, byte[] salt) throws Exception {
		Key key = toKey(password);
		PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
		return cipher.doFinal(data);
	}
	
	/**
	 * 解密
	 * @param data 数据
	 * @param password 密码
	 * @param salt 盐
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception {
		Key key = toKey(password);
		PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
		return cipher.doFinal(data);
	}
	
}

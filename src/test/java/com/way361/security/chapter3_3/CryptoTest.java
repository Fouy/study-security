package com.way361.security.chapter3_3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import org.junit.Test;

/**
 * 3.3 javax.crypto 包详解
 * @author huge
 *
 */
public class CryptoTest {

	/**
	 * 3-17 HmacMD5算法摘要处理
	 * @throws Exception 
	 */
	@Test
	public void testHmacMD5() throws Exception {
		byte[] input = "MAC".getBytes();
		KeyGenerator generator = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = generator.generateKey();
		Mac mac = Mac.getInstance(key.getAlgorithm());
		mac.init(key);
		byte[] output = mac.doFinal(input);
		System.out.println(new BigInteger(output));
	}
	
	/**
	 * 3-18 DH算法秘钥生成
	 * @throws Exception 
	 */
	@Test
	public void testDH() throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("DH");
		KeyPair kp1 = generator.genKeyPair();
		KeyPair kp2 = generator.genKeyPair();
		KeyAgreement agreement = KeyAgreement.getInstance(generator.getAlgorithm());
		agreement.init(kp2.getPrivate());
		agreement.doPhase(kp1.getPublic(), true);
		SecretKey secretKey = agreement.generateSecret("DES");
		System.out.println(secretKey);
	}
	
	/**
	 * 3-19 秘钥输出流加密操作
	 * @throws Exception 
	 */
	@Test
	public void testCipher() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecretKey secretKey = kg.generateKey();
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		String input = "1234567890";
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(new File("secret")), cipher);
		DataOutputStream dos = new DataOutputStream(cos);
		dos.writeUTF(input);
		dos.flush();
		dos.close();
	}
	
	/**
	 * 3-20 对象加密处理
	 * @throws Exception 
	 */
	@Test
	public void testSealedObject() throws Exception {
		String input = "SealedObject";
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		SecretKey key = kg.generateKey();
		Cipher cipher1 = Cipher.getInstance(key.getAlgorithm());
		cipher1.init(Cipher.ENCRYPT_MODE, key);
		SealedObject sealedObject = new SealedObject(input, cipher1);
		Cipher cipher2 = Cipher.getInstance(key.getAlgorithm());
		cipher2.init(Cipher.DECRYPT_MODE, key);
		String output = (String) sealedObject.getObject(cipher2);
		System.out.println(output);
	}
}

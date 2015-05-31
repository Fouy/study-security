package com.way361.security.chapter07_4;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * 7-4 AES算法实现测试
 * @author xuefeihu
 *
 */
public class AESCoderTest {

	@Test
	public void testDESede() throws Exception {
		String inputStr = "AES";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + inputStr);
		byte[] key = AESCoder.initKey();
		System.out.println("秘钥：\t" + Base64.encodeBase64String(key));
		inputData = AESCoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Base64.encodeBase64String(inputData));
		byte[] outputData = AESCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		assertEquals(inputStr, outputStr);
	}
}

package com.way361.security.chapter07_5;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * 7-8 IDEA算法实现测试
 * @author xuefeihu
 *
 */
public class IDEACoderTest {

	@Test
	public void testDESede() throws Exception {
		String inputStr = "IDEA";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + inputStr);
		byte[] key = IDEACoder.initKey();
		System.out.println("秘钥：\t" + Base64.encodeBase64String(key));
		inputData = IDEACoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Base64.encodeBase64String(inputData));
		byte[] outputData = IDEACoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		assertEquals(inputStr, outputStr);
	}
}

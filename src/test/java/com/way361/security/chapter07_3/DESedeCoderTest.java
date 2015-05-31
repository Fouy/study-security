package com.way361.security.chapter07_3;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * 7-4 DESede算法实现测试
 * @author xuefeihu
 *
 */
public class DESedeCoderTest {

	@Test
	public void testDESede() throws Exception {
		String inputStr = "DESede";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + inputStr);
		byte[] key = DESedeCoder.initKey();
		System.out.println("秘钥：\t" + Base64.encodeBase64String(key));
		inputData = DESedeCoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Base64.encodeBase64String(inputData));
		byte[] outputData = DESedeCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		assertEquals(inputStr, outputStr);
	}
}

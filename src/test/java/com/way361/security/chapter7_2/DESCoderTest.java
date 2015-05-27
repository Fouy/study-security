package com.way361.security.chapter7_2;

import static org.junit.Assert.*; 

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * DES算法实现测试用例
 * @author huge
 *
 */
public class DESCoderTest {

	@Test
	public void testDES() throws Exception {
		String inputStr = "DES";
		byte[] inputData = inputStr.getBytes();
		System.out.println("原文：\t" + inputStr);
		//初始化秘钥
		byte[] key = DESCoder.initKey();
		System.out.println("秘钥：\t" + Base64.encodeBase64String(key));
		//加密
		inputData = DESCoder.encrypt(inputData, key);
		System.out.println("加密后：\t" + Base64.encodeBase64String(inputData));
		//解密
		byte[] outputData = DESCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.out.println("解密后：\t" + outputStr);
		assertEquals(inputStr, outputStr);
	}
	
}

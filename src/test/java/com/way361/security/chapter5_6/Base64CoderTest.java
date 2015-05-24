package com.way361.security.chapter5_6;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 5-2 Base64 Test
 * @author huge
 *
 */
public class Base64CoderTest {

	/**
	 * base64编码解码测试
	 * @throws Exception
	 */
	@Test
	public void testBase64() throws Exception {
		String inputStr = "Java加密与解密的艺术";
		System.out.println("原文：\t" + inputStr);
		String code = Base64Coder.encode(inputStr);
		System.out.println("编码后：\t" + code);
		String outputStr = Base64Coder.decode(code);
		System.out.println("解码后：\t" + outputStr);
		assertEquals(inputStr, outputStr);
	}
	 
	
}

package com.way361.security.chapter7_6;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * 7-10 PBE算法实现测试
 * @author xuefeihu
 *
 */
public class PBECoderTest {

	@Test
	public void testPBE() throws Exception {
		String inputStr = "PBE";
		System.out.println("原文：\t" + inputStr);
		byte[] input = inputStr.getBytes();
		String pwd = "xuefeihu";
		System.out.println("密码：\t" + pwd);
		
		byte[] salt = PBECoder.initSalt();
		System.out.println("盐：\t" + Base64.encodeBase64String(salt));
		
		byte[] data = PBECoder.encrypt(input, pwd, salt);
		System.out.println("加密后：\t" + Base64.encodeBase64String(data));
		
		byte[] output = PBECoder.decrypt(data, pwd, salt);
		String outputStr = new String(output);
		System.out.println("解密后：\t" + outputStr);
		
		assertEquals(inputStr, outputStr);
	}
}

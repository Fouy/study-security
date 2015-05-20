package com.way361.security.chapter4_2;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Map;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Test;

/**
 * bouncycastle 测试
 * @author huge
 *
 */
public class BouncyTest {

	@Test
	public void testBouncy() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md = MessageDigest.getInstance("MD4", "BC");
		Provider provider = Security.getProvider("BC");
		System.err.println(provider);
		for(Map.Entry<Object, Object> entry : provider.entrySet()) {
			System.err.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	
	/**
	 * 4-1 Base64 编码/解码
	 * @throws Exception
	 */
	@Test
	public void testBase64() throws Exception {
		String str = "base64编码";
		System.out.println("原文：\t" + str);
		byte[] input = str.getBytes();
		byte[] data = Base64.encode(input);
		System.out.println("编码后：\t" + new String(data));
		byte[] output = Base64.decode(data);
		System.out.println("解码后：\t" + new String(output));
	}
	
	/**
	 * 4-2 Url Base64 编码/解码
	 * @throws Exception
	 */
	@Test
	public void testUrlBase64() throws Exception {
		String str = "base64编码";
		System.out.println("原文：\t" + str);
		byte[] input = str.getBytes();
		byte[] data = UrlBase64.encode(input);
		System.out.println("编码后：\t" + new String(data));
		byte[] output = UrlBase64.decode(data);
		System.out.println("解码后：\t" + new String(output));
	}
	
	/**
	 * 4-3 Hex 编码/解码
	 * @throws Exception
	 */
	@Test
	public void testHex() throws Exception {
		String str = "Hex 编码";
		System.out.println("原文：\t" + str);
		byte[] input = str.getBytes();
		byte[] data = Hex.encode(input);
		System.out.println("编码后：\t" + new String(data));
		byte[] output = Hex.decode(data);
		System.out.println("解码后：\t" + new String(output));
	}
	
	
}

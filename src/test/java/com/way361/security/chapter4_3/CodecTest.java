package com.way361.security.chapter4_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * commons codec 测试
 * @author huge
 *
 */
public class CodecTest {

	/**
	 * 4-4 Base64 编码/解码2
	 * @throws Exception
	 */
	@Test
	public void testBase64() throws Exception {
		String str = "base64编码";
		System.out.println("原文：\t" + str);
		byte[] input = str.getBytes();
		byte[] data = Base64.encodeBase64(input);
		System.out.println("编码后：\t" + new String(data));
		byte[] output = Base64.decodeBase64(data);
		System.out.println("解码后：\t" + new String(output));
	}
	
	/**
	 * 4-5 Base64 输入流操作
	 * @throws Exception
	 */
	@Test
	public void testBase64InputStream() throws Exception {
		ByteArrayInputStream is = new ByteArrayInputStream("".getBytes());
		Base64InputStream input = new Base64InputStream(is, false);
		DataInputStream dis = new DataInputStream(input);
		int contentLength = 0;
		byte[] data = new byte[contentLength];
		dis.readFully(data);
		dis.close();
		System.out.println(new String(data));
	}
	
	/**
	 * 4-6 Base64 输出流操作
	 * @throws Exception
	 */
	@Test
	public void testBase64OutputStream() throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		Base64OutputStream output = new Base64OutputStream(os, false);
		DataOutputStream dos = new DataOutputStream(output);
		dos.write("".getBytes());
		dos.flush();
		dos.close();
	}
	
	/**
	 * 4-7 Hex 编码/解码 2
	 * @throws Exception
	 */
	@Test
	public void testHex2() throws Exception {
		String str = "Hex 编码";
		System.out.println("原文：\t" + str);
		byte[] input = str.getBytes();
		String data = Hex.encodeHexString(input);
		System.out.println("编码后：\t" + data);
		byte[] output = Hex.decodeHex(data.toCharArray());
		System.out.println("解码后：\t" + new String(output));
	}
	
	/**
	 * 4-8 MD5 摘要处理
	 * @throws Exception
	 */
	@Test
	public void testMD5() throws Exception {
		String inputStr = "MD5消息摘要";
		System.out.println("原文：\t" + inputStr);
		String md5Hex = DigestUtils.md5Hex(inputStr);
		System.out.println("加密后：\t" + md5Hex);
	}
	
	
}

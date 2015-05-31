package com.way361.security.chapter06_3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-8 SHA算法实现
 * @author huge
 *
 */
public class SHACoderTest {

	/**
	 * 测试SHA-1
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA() throws Exception {
		String str = "SHA1消息摘要";
		byte[] data1 = SHACoder.encodeSHA(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试SHA-256
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA256() throws Exception {
		String str = "SHA256消息摘要";
		byte[] data1 = SHACoder.encodeSHA256(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA256(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试SHA-384
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA384() throws Exception {
		String str = "SHA384消息摘要";
		byte[] data1 = SHACoder.encodeSHA384(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA384(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试SHA-512
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA512() throws Exception {
		String str = "SHA512消息摘要";
		byte[] data1 = SHACoder.encodeSHA512(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA512(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
}

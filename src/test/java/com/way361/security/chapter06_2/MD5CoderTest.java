package com.way361.security.chapter06_2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-6 MD5算法实现
 * @author huge
 *
 */
public class MD5CoderTest {

	/**
	 * 测试MD5
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD5() throws Exception {
		String str = "MD5消息摘要";
		byte[] data1 = MD5Coder.encodeMD5(str);
		byte[] data2 = MD5Coder.encodeMD5(str);
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试MD5Hex
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD5Hex() throws Exception {
		String str = "MD5Hex消息摘要";
		String data1 = MD5Coder.encodeMD5Hex(str);
		String data2 = MD5Coder.encodeMD5Hex(str);
		assertEquals(data1, data2);
	}
}

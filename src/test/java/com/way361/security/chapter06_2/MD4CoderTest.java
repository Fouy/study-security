package com.way361.security.chapter06_2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-4 MD4算法实现
 * @author huge
 *
 */
public class MD4CoderTest {

	/**
	 * 测试MD4
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD4() throws Exception {
		String str = "MD4消息摘要";
		byte[] data1 = MD4Coder.encodeMD4(str.getBytes());
		byte[] data2 = MD4Coder.encodeMD4(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试MD4Hex
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD4Hex() throws Exception {
		String str = "MD4Hex消息摘要";
		String data1 = MD4Coder.encodeMD4Hex(str.getBytes());
		String data2 = MD4Coder.encodeMD4Hex(str.getBytes());
		assertEquals(data1, data2);
	}
}

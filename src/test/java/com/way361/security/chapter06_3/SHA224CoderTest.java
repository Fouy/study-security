package com.way361.security.chapter06_3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-10 SHA224算法实现
 * @author huge
 *
 */
public class SHA224CoderTest {

	/**
	 * 测试SHA-224
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA224() throws Exception {
		String str = "SHA224消息摘要";
		byte[] data1 = SHA224Coder.encodeSHA224(str.getBytes());
		byte[] data2 = SHA224Coder.encodeSHA224(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试SHA-224Hex
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA224Hex() throws Exception {
		String str = "SHA224Hex消息摘要";
		String data1 = SHA224Coder.encodeSHA224Hex(str.getBytes());
		String data2 = SHA224Coder.encodeSHA224Hex(str.getBytes());
		assertEquals(data1, data2);
	}
	
}

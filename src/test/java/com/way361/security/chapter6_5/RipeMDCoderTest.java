package com.way361.security.chapter6_5;

import static org.junit.Assert.*;

/**
 * 6-18 RipeMD 消息摘要算法测试
 * @author huge
 *
 */
public class RipeMDCoderTest {

	/**
	 * 测试RipeMD128
	 * @throws Exception
	 */
	public final void testRipeMD128() throws Exception {
		String str = "RipeMD128消息摘要";
		byte[] data1 = RipeMDCoder.encodeRipeMD128(str.getBytes());
		byte[] data2 = RipeMDCoder.encodeRipeMD128(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD128Hex
	 * @throws Exception
	 */
	public final void testRipeMD128Hex() throws Exception {
		String str = "RipeMD128Hex消息摘要";
		String data1 = RipeMDCoder.encodeRipeMD128Hex(str.getBytes());
		String data2 = RipeMDCoder.encodeRipeMD128Hex(str.getBytes());
		assertEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD160
	 * @throws Exception
	 */
	public final void testRipeMD160() throws Exception {
		String str = "RipeMD160消息摘要";
		byte[] data1 = RipeMDCoder.encodeRipeMD160(str.getBytes());
		byte[] data2 = RipeMDCoder.encodeRipeMD160(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD160Hex
	 * @throws Exception
	 */
	public final void testRipeMD160Hex() throws Exception {
		String str = "RipeMD160Hex消息摘要";
		String data1 = RipeMDCoder.encodeRipeMD160Hex(str.getBytes());
		String data2 = RipeMDCoder.encodeRipeMD160Hex(str.getBytes());
		assertEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD256
	 * @throws Exception
	 */
	public final void testRipeMD256() throws Exception {
		String str = "RipeMD256消息摘要";
		byte[] data1 = RipeMDCoder.encodeRipeMD256(str.getBytes());
		byte[] data2 = RipeMDCoder.encodeRipeMD256(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD256Hex
	 * @throws Exception
	 */
	public final void testRipeMD256Hex() throws Exception {
		String str = "RipeMD256Hex消息摘要";
		String data1 = RipeMDCoder.encodeRipeMD256Hex(str.getBytes());
		String data2 = RipeMDCoder.encodeRipeMD256Hex(str.getBytes());
		assertEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD320
	 * @throws Exception
	 */
	public final void testRipeMD320() throws Exception {
		String str = "RipeMD320消息摘要";
		byte[] data1 = RipeMDCoder.encodeRipeMD320(str.getBytes());
		byte[] data2 = RipeMDCoder.encodeRipeMD320(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试RipeMD320Hex
	 * @throws Exception
	 */
	public final void testRipeMD320Hex() throws Exception {
		String str = "RipeMD320Hex消息摘要";
		String data1 = RipeMDCoder.encodeRipeMD320Hex(str.getBytes());
		String data2 = RipeMDCoder.encodeRipeMD320Hex(str.getBytes());
		assertEquals(data1, data2);
	}
	
}

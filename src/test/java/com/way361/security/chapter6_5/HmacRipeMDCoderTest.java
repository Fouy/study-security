package com.way361.security.chapter6_5;

import static org.junit.Assert.*;

/**
 * 6-20 HmacRipeMD 消息摘要算法测试
 * @author huge
 *
 */
public class HmacRipeMDCoderTest {

	/**
	 * 测试HmacRipeMD128
	 * @throws Exception
	 */
	public final void testHmacRipeMD128() throws Exception {
		String str = "HmacRipeMD128消息摘要";
		byte[] key = HmacRipeMDCoder.initHmacRipeMD128Key();
		byte[] data1 = HmacRipeMDCoder.encodeHmacRipeMD128(str.getBytes(), key);
		byte[] data2 = HmacRipeMDCoder.encodeHmacRipeMD128(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试HmacRipeMD128Hex
	 * @throws Exception
	 */
	public final void testHmacRipeMD128Hex() throws Exception {
		String str = "HmacRipeMD128Hex消息摘要";
		byte[] key = HmacRipeMDCoder.initHmacRipeMD128Key();
		String data1 = HmacRipeMDCoder.encodeHmacRipeMD128Hex(str.getBytes(), key);
		String data2 = HmacRipeMDCoder.encodeHmacRipeMD128Hex(str.getBytes(), key);
		assertEquals(data1, data2);
	}
	
	/**
	 * 测试HmacRipeMD160
	 * @throws Exception
	 */
	public final void testHmacRipeMD160() throws Exception {
		String str = "HmacRipeMD160消息摘要";
		byte[] key = HmacRipeMDCoder.initHmacRipeMD160Key();
		byte[] data1 = HmacRipeMDCoder.encodeHmacRipeMD160(str.getBytes(), key);
		byte[] data2 = HmacRipeMDCoder.encodeHmacRipeMD160(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试HmacRipeMD160Hex
	 * @throws Exception
	 */
	public final void testHmacRipeMD160Hex() throws Exception {
		String str = "HmacRipeMD160Hex消息摘要";
		byte[] key = HmacRipeMDCoder.initHmacRipeMD160Key();
		String data1 = HmacRipeMDCoder.encodeHmacRipeMD160Hex(str.getBytes(), key);
		String data2 = HmacRipeMDCoder.encodeHmacRipeMD160Hex(str.getBytes(), key);
		assertEquals(data1, data2);
	}
	
}

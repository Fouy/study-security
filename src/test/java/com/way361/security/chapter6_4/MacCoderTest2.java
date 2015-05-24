package com.way361.security.chapter6_4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-16 MAC算法实现测试2
 * @author huge
 *
 */
public class MacCoderTest2 {
	
	@Test
	public final void testHmacMD2() throws Exception {
		String str = "HmacMD2消息摘要";
		byte[] key = MACCoder2.initHmacMD2Key();
		byte[] data1 = MACCoder2.encodeHmacMD2(str.getBytes(), key);
		byte[] data2 = MACCoder2.encodeHmacMD2(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacMD4() throws Exception {
		String str = "HmacMD4消息摘要";
		byte[] key = MACCoder2.initHmacMD4Key();
		byte[] data1 = MACCoder2.encodeHmacMD4(str.getBytes(), key);
		byte[] data2 = MACCoder2.encodeHmacMD4(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacSHA224() throws Exception {
		String str = "HmacSHA224消息摘要";
		byte[] key = MACCoder2.initHmacSHA224Key();
		byte[] data1 = MACCoder2.encodeHmacSHA224(str.getBytes(), key);
		byte[] data2 = MACCoder2.encodeHmacSHA224(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
}

package com.way361.security.chapter6_4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 6-14 MAC算法实现测试
 * @author huge
 *
 */
public class MacCoderTest {
	
	@Test
	public final void testHmacMD5() throws Exception {
		String str = "HmacMD5消息摘要";
		byte[] key = MACCoder.initHmacMD5Key();
		byte[] data1 = MACCoder.encodeHmacMD5(str.getBytes(), key);
		byte[] data2 = MACCoder.encodeHmacMD5(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacSHA1() throws Exception {
		String str = "HmacSHA1消息摘要";
		byte[] key = MACCoder.initHmacSHAKey();
		byte[] data1 = MACCoder.encodeHmacSHA(str.getBytes(), key);
		byte[] data2 = MACCoder.encodeHmacSHA(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacSHA256() throws Exception {
		String str = "HmacSHA256消息摘要";
		byte[] key = MACCoder.initHmacSHA256Key();
		byte[] data1 = MACCoder.encodeHmacSHA256(str.getBytes(), key);
		byte[] data2 = MACCoder.encodeHmacSHA256(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacSHA384() throws Exception {
		String str = "HmacSHA384消息摘要";
		byte[] key = MACCoder.initHmacSHA384Key();
		byte[] data1 = MACCoder.encodeHmacSHA384(str.getBytes(), key);
		byte[] data2 = MACCoder.encodeHmacSHA384(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}
	
	@Test
	public final void testHmacSHA512() throws Exception {
		String str = "HmacSHA512消息摘要";
		byte[] key = MACCoder.initHmacSHA512Key();
		byte[] data1 = MACCoder.encodeHmacSHA512(str.getBytes(), key);
		byte[] data2 = MACCoder.encodeHmacSHA512(str.getBytes(), key);
		assertArrayEquals(data1, data2);
	}

}

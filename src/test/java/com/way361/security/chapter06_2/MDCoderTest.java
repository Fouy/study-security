package com.way361.security.chapter06_2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * 6-2 MD2和MD5算法实现测试用例
 * @author xuefeihu
 *
 */
public class MDCoderTest {

	/**
	 * 测试MD2
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD2() throws Exception {
		String str = "MD2消息摘要";
		byte[] data1 = MDCoder.encodeMD2(str.getBytes());
		byte[] data2 = MDCoder.encodeMD2(str.getBytes());
		assertArrayEquals(data1, data2);
	}
	
	/**
	 * 测试MD5
	 * @throws Exception
	 */
	@Test
	public final void testEncodeMD5() throws Exception {
		String str = "MD5消息摘要";
		byte[] data1 = MDCoder.encodeMD5(str.getBytes());
		byte[] data2 = MDCoder.encodeMD5(str.getBytes());
		assertArrayEquals(data1, data2);
	}
}

package com.way361.security.chapter06_6;

import java.util.zip.CRC32;

import org.junit.Test;

/**
 * CRC32 算法实现
 * @author huge
 *
 */
public class CRCTest {

	@Test
	public void testCRC32() throws Exception {
		String str = "测试CRC-32";
		CRC32 crc32 = new CRC32();
		crc32.update(str.getBytes());
		String hex = Long.toHexString(crc32.getValue());
		System.out.println("原文：\t" + str);
		System.out.println("CRC32:\t" + hex);
	}
	
}

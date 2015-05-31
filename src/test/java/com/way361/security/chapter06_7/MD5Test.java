package com.way361.security.chapter06_7;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * 6-22 校验下载文件的一致性
 * @author huge
 *
 */
public class MD5Test {

	/**
	 * 校验文件1
	 * @throws Exception
	 */
	@Test
	public void testByMessageDigest() throws Exception {
		String path = "D:/mysql-5.1.msi";
		FileInputStream inputStream = new FileInputStream(path);
		DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("MD5"));
		int buf = 1024;
		byte[] buffer = new byte[buf];
		int read = digestInputStream.read(buffer, 0, buf);
		while(read > -1) {
			read = digestInputStream.read(buffer, 0, buf);
		}
		digestInputStream.close();
		MessageDigest md = digestInputStream.getMessageDigest();
		byte[] b = md.digest();
		String md5hex = Hex.encodeHexString(b);
		assertEquals(md5hex, "");
	}
	
	/**
	 * 校验文件2
	 * @throws Exception
	 */
	@Test
	public void testByDigestUtils() throws Exception {
		String path = "D:/mysql-5.1.msi";
		FileInputStream inputStream = new FileInputStream(path);
		String md5hex = DigestUtils.md5Hex(inputStream);
		inputStream.close();
		assertEquals(md5hex, "");
	}
	
}

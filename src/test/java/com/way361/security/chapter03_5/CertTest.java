package com.way361.security.chapter03_5;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Signature;
import java.security.cert.CRL;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;

import org.junit.Test;

/**
 * 3.5 java.security.cert 包详解
 * @author huge
 *
 */
public class CertTest {
	
	/**
	 * 3-21 加载证书
	 * @throws Exception 
	 */
	@Test
	public void testCertFactory() throws Exception {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream inputStream = new FileInputStream("D:/x.keystore");
		Certificate certificate = certificateFactory.generateCertificate(inputStream);
		inputStream.close();
		System.out.println(certificate);
	}
	
	/**
	 * 3-22 获得证书签名
	 * @throws Exception 
	 */
	@Test
	public void testKeyStore() throws Exception {
		FileInputStream inputStream = new FileInputStream("D:/x.keystore");
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(inputStream, "password".toCharArray());
		inputStream.close();
		X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate("alias");
		Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
		System.out.println(signature);
	}
	
	/**
	 * 3-23 获得证书撤销列表
	 * @throws Exception 
	 */
	@Test
	public void testCertRevoked() throws Exception {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:/x.keystore");
		CRL crl = certificateFactory.generateCRL(in);
		in.close();
		System.out.println(crl);
	}
	
	/**
	 * 3-24 获得证书撤销列表实体
	 * @throws Exception 
	 */
	@Test
	public void testCertRevokedEntity() throws Exception {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:/x.keystore");
		X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(in);
		X509CRL x509crl = (X509CRL) certificateFactory.generateCRL(in);
		@SuppressWarnings("unused")
		X509CRLEntry x509crlEntry = x509crl.getRevokedCertificate(x509Certificate);
		in.close();
		System.out.println(x509crl);
	}
	
	/**
	 * 3-25 获得证书链
	 * @throws Exception 
	 */
	@Test
	public void testCertLink() throws Exception {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("D:/x.keystore");
		CertPath certPath = certificateFactory.generateCertPath(in);
		in.close();
		System.out.println(certPath);
	}

}

package com.way361.security.chapter03_2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.CodeSigner;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignedObject;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.junit.Test;

public class SecurityTest {
	
	/**
	 * 3-1
	 */
	@Test
	public void testProvider() {
		for(Provider provider : Security.getProviders()) {
			System.out.println(provider);
			for(Map.Entry<Object, Object> entry : provider.entrySet()) {
				System.out.println("\t" + entry.getKey());
			}
		}
	}
	
	/**
	 * 3-2
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	public void testMessageDigest() throws NoSuchAlgorithmException {
		byte[] input = "sha".getBytes();
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(input);
		byte[] output = sha.digest();
		System.out.println(output.length);
	}
	
	/**
	 * 3-4
	 * @throws Exception 
	 */
	@Test
	public void testMD5() throws Exception {
		byte[] input = "md5".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		DigestInputStream dis = new DigestInputStream(new ByteArrayInputStream(input), md);
		dis.read(input, 0, input.length);
		byte[] output = dis.getMessageDigest().digest();
		dis.close();
		System.out.println(output.length);
	}
	
	/**
	 * 3-6
	 * @throws Exception 
	 */
	@Test
	public void testMD5Stream() throws Exception {
		byte[] input = "md5".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		DigestOutputStream dos = new DigestOutputStream(new ByteArrayOutputStream(), md);
		dos.write(input, 0, input.length);
		byte[] output = dos.getMessageDigest().digest();
		dos.flush();
		dos.close();
		System.out.println(output.length);
	}
	
	/**
	 * 3-7
	 * @throws Exception 
	 */
	@Test
	public void testDES() throws Exception {
		AlgorithmParameters ap = AlgorithmParameters.getInstance("DES");
		ap.init(new BigInteger("19050619766489163472469").toByteArray());
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
	
	/**
	 * 3-8
	 * @throws Exception 
	 */
	@Test
	public void testGenerator() throws Exception {
		AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DES");
		apg.init(56);
		AlgorithmParameters ap = apg.generateParameters();
		byte[] b = ap.getEncoded();
		System.out.println(new BigInteger(b).toString());
	}
	
	/**
	 * 3-9
	 * @throws Exception 
	 */
	@Test
	public void testKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		byte[] keyBytes = keyPair.getPrivate().getEncoded();
		PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		Key privateKey = factory.generatePrivate(encodedKeySpec);
		System.out.println(privateKey);
	}
	
	/**
	 * 3-10
	 * @throws Exception 
	 */
	@Test
	public void testSecureRandom() throws Exception {
		SecureRandom random = new SecureRandom();
		KeyGenerator generator = KeyGenerator.getInstance("DES");
		generator.init(random);
		SecretKey key = generator.generateKey();
		System.out.println(key);
	}
	
	/**
	 * 3-11
	 * @throws Exception 
	 */
	@Test
	public void testSignature() throws Exception {
		byte[] data = "Signature Data".getBytes();
		KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("DSA");
		pairGenerator.initialize(1024);
		KeyPair keyPair = pairGenerator.generateKeyPair();
		Signature signature = Signature.getInstance(pairGenerator.getAlgorithm());
		signature.initSign(keyPair.getPrivate());
		signature.update(data);
		byte[] sign = signature.sign();
		signature.initVerify(keyPair.getPublic());
		signature.update(data);
		boolean result = signature.verify(sign);
		System.out.println(result);
	}
	
	/**
	 * 3-12 数字签名对象处理
	 * @throws Exception 
	 */
	@Test
	public void testSignatureObject() throws Exception {
		byte[] data = "Signature Data".getBytes();
		KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("DSA");
		pairGenerator.initialize(1024);
		KeyPair keyPair = pairGenerator.generateKeyPair();
		Signature signature = Signature.getInstance(pairGenerator.getAlgorithm());
		SignedObject signedObject = new SignedObject(data, keyPair.getPrivate(), signature);
		byte[] sign = signedObject.getSignature();
		boolean result = signedObject.verify(keyPair.getPublic(), signature);
		System.out.println(result);
	}
	
	/**
	 * 3-13 获得数字时间戳
	 * @throws Exception 
	 */
	@Test
	public void testTimestamp() throws Exception {
		CertificateFactory cf = CertificateFactory.getInstance("X509");
		CertPath certPath = cf.generateCertPath(new FileInputStream("D:\\x.cer"));
		Timestamp timestamp = new Timestamp(new Date(), certPath);
		System.out.println(timestamp);
	}
	
	/**
	 * 3-15 验证代码签名
	 * @throws Exception 
	 */
	@Test
	public void testSignCode() throws Exception {
		CertificateFactory cf = CertificateFactory.getInstance("X509");
		CertPath certPath = cf.generateCertPath(new FileInputStream("D:\\x.cer"));
		Timestamp timestamp = new Timestamp(new Date(), certPath);
		CodeSigner codeSigner = new CodeSigner(certPath, timestamp);
		boolean result = codeSigner.equals(new CodeSigner(certPath, timestamp));
		System.out.println(result);
	}
	
	/**
	 * 3-16 加载秘钥库
	 * @throws Exception 
	 */
	@Test
	public void testKeyStore() throws Exception {
		FileInputStream inputStream = new FileInputStream("D:\\.keystore");
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(inputStream, "password".toCharArray());
		inputStream.close();
		PrivateKey key = (PrivateKey) keyStore.getKey("alias", "password".toCharArray());
		System.out.println(key);
	}
	
}

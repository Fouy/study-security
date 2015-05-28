package com.way361.security.chapter7_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 7-11 HttpUtils
 * @author huge
 *
 */
public abstract class HttpUtils {

	public static final String CHARACTER_ENCODING = "UTF-8";
	public static final String METHOD_POST = "POST";
	public static final String CONTENT_TYPE = "Content-Type";
	
	/**
	 * 打印数据
	 * @param response HttpServletResponse
	 * @param data 待打印的数据
	 * @throws Exception
	 */
	public static void responseWrite(HttpServletResponse response, byte[] data) throws Exception {
		if(data != null) {
			response.setContentLength(data.length);
			DataOutputStream output = new DataOutputStream(response.getOutputStream());
			output.write(data);
			output.flush();
			output.close();
		}
	}
	
	/**
	 * 从请求中读字节流
	 * @param request
	 * @return byte[] 数据
	 * @throws Exception
	 */
	public static byte[] requestRead(HttpServletRequest request) throws Exception {
		int contentLength = request.getContentLength();
		byte[] data = null;
		if(contentLength > 0) {
			data = new byte[contentLength];
			InputStream is = request.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			dis.readFully(data);
			dis.close();
		}
		return data;
	}
	
	/**
	 * 以POST方式向指定地址发送数据报请求，并取回返回的数据包
	 * @param urlString 请求地址
	 * @param requestData 请求数据
	 * @return byte[] 数据包
	 * @throws Exception
	 */
	public static byte[] postRequest(String urlString, byte[] requestData) throws Exception {
		Properties requestProperties = new Properties();
		requestProperties.setProperty(CONTENT_TYPE, "application/octet-stream;charset=" + CHARACTER_ENCODING);
		return postRequest(urlString, requestData, requestProperties);
	}

	/**
	 * 以POST方式向指定地址发送数据报请求，并取回返回的数据包
	 * @param urlString 请求地址
	 * @param requestData 请求数据
	 * @param requestProperties 请求包体
	 * @return byte[] 数据包
	 */
	private static byte[] postRequest(String urlString, byte[] requestData,
			Properties requestProperties) throws Exception {
		byte[] responseData = null;
		HttpURLConnection con = null;
		try {
			URL url = new URL(urlString);
			con = (HttpURLConnection) url.openConnection();
			if(requestProperties != null && requestProperties.size() > 0) {
				for(Map.Entry<Object, Object> entry : requestProperties.entrySet()) {
					String key = String.valueOf(entry.getKey());
					String value = String.valueOf(entry.getValue());
					con.setRequestProperty(key, value);
				}
			}
			con.setRequestMethod(METHOD_POST);
			con.setDoOutput(true);
			con.setDoInput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			if(requestData != null) {
				dos.write(requestData);
			}
			dos.flush();
			dos.close();
			DataInputStream dis = new DataInputStream(con.getInputStream());
			int length = con.getContentLength();
			if(length > 0) {
				responseData = new byte[length];
				dis.readFully(responseData);
			}
			dis.close();
		} finally {
			if(con != null) {
				con.disconnect();
				con = null;
			}
		}
		return responseData;
	}
	
}

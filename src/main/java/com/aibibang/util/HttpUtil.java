package com.aibibang.util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/** 
* @author: Truman.P.Du 
* @since: 2016年8月17日 下午3:31:24 
* @version: v1.0
* @description:
*/
public class  HttpUtil {
	@SuppressWarnings("rawtypes")
	public static HttpResponse  doPost(String uri, Map data){
		HttpPost post = new HttpPost(uri);
		HttpResponse response = null;
		try {
			ObjectMapper mapper= new ObjectMapper();
			HttpEntity entity=new StringEntity(mapper.writeValueAsString(data));
			post.setEntity(entity);
			response = HttpClientBuilder.create().build().execute(post);
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static HttpResponse doGet(String uri){
		HttpGet get = new HttpGet(uri);
		HttpResponse response = null;
		try {
			response = HttpClientBuilder.create().build().execute(get);
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static String getData(HttpResponse response) {
		try {
			if (response.getStatusLine().getStatusCode() == 200) {
				StringBuffer json = new StringBuffer();
				byte[] temp = new byte[1024];
				InputStream in = response.getEntity().getContent();
				int len = 0;
				while ((len = in.read(temp)) != -1) {
					json.append(new String(Arrays.copyOfRange(temp, 0, len)));
				}
				
				return json.toString();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

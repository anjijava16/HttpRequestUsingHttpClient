package com.iwinner.acs.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class MyInjectLocalUrlServlet {
	public static void main(String[] args) {
		//sendParmas2();
		sendParams3();
/*		try {
			PostMethod method = new PostMethod("http://localhost:2626/XmlGetting/inject");
			RequestEntity req = new StringRequestEntity(
					WsFactory.getCustomerRequest());
			method.setRequestEntity(req);
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setSoTimeout(10000);
			// System.out.println(client.getPort()+"   "+client.getState());
			int returnCode = client.executeMethod(method);
			String res = method.getResponseBodyAsString();
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/	}
	public void sendingParameters(){
		try{
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.addAll(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://localhost/handler.do");
		httppost.setEntity(entity);
		}catch(Exception e){
			
		}
		
	}
	
	
	public void sendParamn3(){c
		
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("param1", "Hello"));
		params.add(new BasicNameValuePair("param2", "Anji"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		
	}
	
	public static void sendParmas2(){
/*		try{HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://localhost:2626/XmlGetting/httpSer");

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("param1", "Hello"));
		params.add(new BasicNameValuePair("param2", "Anji"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
          
		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		  System.out.println(httppost.getParams().getParameter("param1")+""+httppost.getURI());
		System.out.println("Response From "+response);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    System.out.println(instream.read());
		}
        System.out.println(entity+"   "+ response.getEntity());
		}catch(Exception e){
			e.printStackTrace();
		}
*/	
	try{
		HttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://localhost:2626/XmlGetting/httpSer");
		httppost.setEntity(entity);
		System.out.println(entity.getContentLength()+"  "+entity.getContent());
		HttpParams pas=httppost.getParams();
		System.out.println(pas.getParameter("param1"));
		HttpResponse response = httpclient.execute(httppost);
		System.out.println(response.getEntity());
	}catch(Exception e){
		e.printStackTrace();
	}
	
	}
	
	public static void sendParams3(){
		
		HttpClient client = HttpClients.createDefault();
	    HttpPost post = new HttpPost("http://localhost:2626/XmlGetting/httpSer");
	    try {
	      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	      nameValuePairs.add(new BasicNameValuePair("param1", "KsP123456789"));
	      nameValuePairs.add(new BasicNameValuePair("param2", "AnjiM123456789"));
	      post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	      HttpResponse response = client.execute(post);

	      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	      String line = "";
	      while ((line = rd.readLine()) != null) {
	        System.out.println(line);
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}
}

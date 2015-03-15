package com.iwinner.ws.maxis;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.iwinner.ws.vo.AbstractValueObject;
import com.iwinner.ws.vo.AdCommonVO;
import com.iwinner.ws.vo.AdItVO;

public class AditClient {

	public static void main(String[] args) {
		AdCommonVO adCommonVO=new AdCommonVO();
		 AbstractValueObject valueObject = null;
		try{
			String res=null;
			System.out.println(WsFactory.getAdItService());
			PostMethod method = new PostMethod(WsFactory.getAdItService());
			RequestEntity req = new StringRequestEntity(WsFactory.getRequest());
			method.setRequestEntity(req);
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setSoTimeout(10000);
			System.out.println(client.getPort()+"   "+client.getState());
			 int returnCode = client.executeMethod(method);
			 res = method.getResponseBodyAsString();
			 System.out.println(res);
			 System.out.println("Ending here$$$$$$$$$$$$$$$$$");
			 int firstIndex = res.indexOf("<opportunityId>");
			   int lastIndex = res.indexOf("</response>");
			  if ((firstIndex != -1) && (lastIndex != -1) && (res != null))
			  {
			    res = res.substring(firstIndex, lastIndex);
			    System.out.println(res);
			    valueObject = new AdItVO(res);
			   }
			  int firstMedia=res.indexOf("<adId>");
			  int lastMedia=res.indexOf("</adId>");
			  String adId=res.substring(firstMedia, lastMedia);
			  System.out.println("adID::>>>>>>>>>."+adId);
			  //System.out.println(valueObject);
			 //System.out.println(res);
			 System.out.println(returnCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

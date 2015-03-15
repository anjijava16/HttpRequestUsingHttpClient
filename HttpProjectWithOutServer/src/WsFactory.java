package com.iwinner.ws.maxis;

import java.net.URL;

import my.com.maxis.www.BO.MyAccount.MyAccount;
import my.com.maxis.www.BO.MyAccount.Binding.MyAccountInformationService_MyAccountHttpBindingStub;
import my.com.maxis.www.BO.MyAccount.Binding.MyAccountInformationService_MyAccountHttpServiceLocator;

import org.apache.axis.AxisFault;

public class WsFactory {
   private static MyAccount myAccount;
   private static MyAccountInformationService_MyAccountHttpServiceLocator srv_myAccount;

	public static Object getAccountService() throws AxisFault, Exception {
		if (myAccount == null) {
			myAccount = new MyAccountInformationService_MyAccountHttpBindingStub(
					new URL("http://172.16.136.201:8080/MyAccountServiceWeb/sca/MyAccountInformationService"),srv_myAccount);
		}
		return myAccount;
	}
	
	public static String getRequest(){
		String request=null;
		request="<request xmlns=\"http://www.mobixell.com\" xmlns:ns2=\"http://www.mobixell.com/common\"><opportunity><channel>WAP</channel><initiatorUserId>601127773250</initiatorUserId><receiverUserId>601127773250</receiverUserId><receiverUserAgent>Nokia110/2.0 (03.47) Profile/MIDP-2.1 Configuration/CLDC-1.1</receiverUserAgent><srcUrl>http://m.maxis.com.my</srcUrl><context><keywords>Home</keywords><site>http://m.maxis.com.my</site></context><adMaxSize>300000</adMaxSize><acceptableAdTypes><adType name=\"BANNER\"><preferredAdParams><dimensions><ns2:width>216</ns2:width><ns2:height>36</ns2:height></dimensions><supportedMimeTypes>image/*</supportedMimeTypes></preferredAdParams></adType></acceptableAdTypes></opportunity><operationMode><injectorAdaptsMedia>false</injectorAdaptsMedia><allowMultipleAds>false</allowMultipleAds><adServerAutoCommitView>true</adServerAutoCommitView></operationMode></request>";
		return request;
	}
	public static String getAdItService()
	{
		//http://s/adselector/inject/ (Production)
		//http://10.200.52.225:8080/adselector/inject/
	     return "http://10.200.52.225:8080/adselector/inject/";
	   }
	public static String getCustomerRequest(){
		String customerRequest="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer id=\"100\"><age>29</age><name>mkyong</name></customer>";
		return customerRequest;
	}
	public static void main(String[] args) {
		System.out.println(getCustomerRequest());
	}
}

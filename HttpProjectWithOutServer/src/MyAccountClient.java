package com.iwinner.ws.maxis;

import my.com.maxis.www.BO.MyAccount.BaseRequest;
import my.com.maxis.www.BO.MyAccount.MyAccount;
import my.com.maxis.www.BO.MyAccount.PostpaidAccountResponse;
import my.com.maxis.www.BO.MyAccount.PostpaidAccountResult;
import my.com.maxis.www.BO.MyAccount.PostpaidServiceData;
import my.com.maxis.www.BO.MyAccount.PreviousPayment;
import my.com.maxis.www.BO.MyAccount.Binding.MyAccountInformationService_MyAccountHttpBindingStub;
import my.com.maxis.www.BO.MyAccount.Binding.MyAccountInformationService_MyAccountHttpServiceLocator;

public class MyAccountClient {
	private static MyAccountInformationService_MyAccountHttpServiceLocator srv_myAccount;

	public static void main(String[] args) {
		try {
			java.net.URL endpointURL = new java.net.URL(
					"http://172.16.136.201:8080/MyAccountServiceWeb/sca/MyAccountInformationService");
			System.out.println(endpointURL.getUserInfo());
			MyAccount myAccount = (MyAccount) WsFactory.getAccountService();
			MyAccountInformationService_MyAccountHttpBindingStub mStub = new MyAccountInformationService_MyAccountHttpBindingStub(
					endpointURL, srv_myAccount);
			BaseRequest baseReq = new BaseRequest();
			baseReq.setMSISDN("60173348952");
			RetrievePostpaidAccountInformationRequest retrievePostpaidAccountInformationRequest = new RetrievePostpaidAccountInformationRequest();
			retrievePostpaidAccountInformationRequest.setRequest(baseReq);
			System.out.println("RetrievePostPaidAccount:::"+retrievePostpaidAccountInformationRequest.getRequest());
			PostpaidAccountResponse service = myAccount	.retrievePostpaidAccountInformation(retrievePostpaidAccountInformationRequest.getRequest());
			
			PostpaidServiceData pServiceData=service.getServiceResponse().getServiceData();
			
			System.out.println("Starting the values checking ......");
			
			PreviousPayment p[]=new PreviousPayment[2];
			System.out.println(pServiceData.getDueDate()+"   "+pServiceData.getPaymentResponsibility()+"  "+pServiceData.getPreviousPayments(0).getPaymentDate()+"  "+pServiceData.getPreviousPayments(1).getPaymentAmount());
			
			System.out.println("Ending  the values checking ......");
			
			/*
			PreviousPayment payMe=new PreviousPayment();
			PostpaidAccountResult postAccountRes=new PostpaidAccountResult();
			postAccountRes.setServiceData(pServiceData);
			System.out.println("Starting the values checking ......");
			System.out.println(postAccountRes.getServiceData().getTotalCurrentBill());
			System.out.println("Ending  the values checking ......");
			pServiceData.setDueDate("");
			*///postPaidAccountResponse.setServiceResponse(serviceResponse)
			/*ServiceHeader sHeader = new ServiceHeader();
			SecurityHeaderType securityHeaer = new SecurityHeaderType();
			PostpaidAccountResponse pResponse = mStub
					.retrievePostpaidAccountInformation(baseReq);
			// System.out.println(pResponse.getServiceResponse());
*/		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

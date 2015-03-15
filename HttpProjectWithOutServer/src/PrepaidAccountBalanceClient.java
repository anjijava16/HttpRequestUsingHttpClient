package com.iwinner.ws.maxis;

import my.com.maxis.www.BO.MyAccount.BaseRequest;
import my.com.maxis.www.BO.MyAccount.Field;
import my.com.maxis.www.BO.MyAccount.MyAccount;
import my.com.maxis.www.BO.MyAccount.PrepaidAccountResponse;
import my.com.maxis.www.BO.MyAccount.Binding.MyAccountInformationService_MyAccountHttpServiceLocator;

public class PrepaidAccountBalanceClient {
	private static MyAccountInformationService_MyAccountHttpServiceLocator srv_myAccount;
	
	public static void main(String[] args) {
		try {
			
			java.net.URL endpointURL = new java.net.URL(
					"http://172.16.136.201:8080/MyAccountServiceWeb/sca/MyAccountInformationService");
			System.out.println(endpointURL.getUserInfo());
			MyAccount myAccount = (MyAccount) WsFactory.getAccountService();
      //	MyAccountInformationService_MyAccountHttpBindingStub mStub = new MyAccountInformationService_MyAccountHttpBindingStub(endpointURL, srv_myAccount);
			BaseRequest baseReq = new BaseRequest();
			baseReq.setMSISDN("601112302857"); //60102971710 //601127677737  //601112302857
			RetrievePrepaidAccountInformationRequest retrievePrepaidAccountInformationRequest = new RetrievePrepaidAccountInformationRequest();
			retrievePrepaidAccountInformationRequest.setRequest(baseReq);

			PrepaidAccountResponse service = myAccount.retrievePrepaidAccountInformation(retrievePrepaidAccountInformationRequest.getRequest());
			System.out.println(service.getServiceResponse().getServiceData());
			Field[] fs=service.getServiceResponse().getServiceData();
			System.out.println(fs.length);
			for(int i=0;i<fs.length;i++){
				System.out.println(fs[i].getId()+"  "+fs[i].getValue()+"  ");
			}
			//PostpaidServiceData pServiceData=service.getServiceResponse().getServiceStatus().getStatusCode();
			/*
			System.out.println("Starting the values checking ......");
			
			PreviousPayment p[]=new PreviousPayment[2];
			System.out.println(pServiceData.getDueDate()+"   "+pServiceData.getPaymentResponsibility()+"  "+pServiceData.getPreviousPayments(0).getPaymentDate()+"  "+pServiceData.getPreviousPayments(1).getPaymentAmount());
			
			System.out.println("Ending  the values checking ......");
			*/
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

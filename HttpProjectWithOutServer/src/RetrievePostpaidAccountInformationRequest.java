package com.iwinner.ws.maxis;

import my.com.maxis.www.BO.MyAccount.BaseRequest;

public class RetrievePostpaidAccountInformationRequest
  {
   private BaseRequest request;
   public BaseRequest getRequest()
   {
     return this.request;
  }
   public void setRequest(BaseRequest request)
   {
     this.request = request;
   }
}
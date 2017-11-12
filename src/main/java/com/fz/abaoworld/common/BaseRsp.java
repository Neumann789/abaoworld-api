package com.fz.abaoworld.common;

public class BaseRsp<T> {
	
	private String rspCode;
	
	private String rspMsg;
	
	private T body;

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
	public BaseRsp() {
	}
	public BaseRsp(RspCodeEnum rspcode) {
		this.rspCode = rspcode.getRspCode();
		this.rspMsg = rspcode.getRspMsg();
	}
	
	public BaseRsp(RspCodeEnum rspcode,T t) {
		this.rspCode = rspcode.getRspCode();
		this.rspMsg = rspcode.getRspMsg();
		this.body = t;
	}
	
	public static BaseRsp returnSuccess(){
		return new BaseRsp<>(RspCodeEnum.SUCCESS);
	}
	
	public static BaseRsp returnFail(){
		return new BaseRsp<>(RspCodeEnum.FAIL);
	}
	

}

package com.fz.abaoworld.common;

public enum RspCodeEnum {

	SUCCESS("0000","成功"),
	FAIL("9999","失败"),
	
	B_SESSION_IS_INVALID("S9998", "session is  invalid"),
	
	;
	
	
	/** 返回码 */
	private String rspCode;

	/** 返回码描述 */
	private String rspMsg;
	
	
	RspCodeEnum (){}
	
	RspCodeEnum(String rspCode,String rspMsg){
	
			this.rspCode = rspCode;
			
			this.rspMsg = rspMsg;
	}

	public String getRspCode() {
		return rspCode;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public String getRspMsg() {
		return rspMsg;
	}
	
	public String getRspMsg(Object... args) {
		return String.format(this.rspMsg, args);
	}
}

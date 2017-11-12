package com.fz.abaoworld.common;


public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = 4466400429612546992L;

	private String rspCode;
	
	private String rspMsg;
	
	public BaseException() {
		
	}
	
	public BaseException(String rspCode,String rspMsg) {
		super(rspCode+"-"+rspMsg);
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}
	
	public BaseException(RspCodeEnum rspcodeEnum) {
		super(rspcodeEnum.getRspCode()+"-"+rspcodeEnum.getRspMsg());
		this.rspCode = rspcodeEnum.getRspCode();
		this.rspMsg = rspcodeEnum.getRspMsg();
	}
	
	public BaseException(RspCodeEnum resp, Object... args){
		
		super(getCodeAndMsg(resp, args));
		
		this.rspCode = resp.getRspCode();
		
		if(args.length!=0){
			
			this.rspMsg = resp.getRspMsg(args);
			
		}else{
			
			this.rspMsg = resp.getRspMsg().replaceAll("%s", "");
			
		}
		
	}

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
	
	public static String getCodeAndMsg(RspCodeEnum  resp, Object... args){
		
		String code = resp.getRspCode();
		
		String msg = null;
		
		if(args.length!=0){
			
			msg = resp.getRspMsg(args);
			
		}else{
			
			msg = resp.getRspMsg().replaceAll("%s", "");
			
		}
		return code+"-"+msg;
	}
}

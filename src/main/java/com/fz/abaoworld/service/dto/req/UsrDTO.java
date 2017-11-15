package com.fz.abaoworld.service.dto.req;

import java.io.Serializable;

public class UsrDTO implements Serializable{
	private static final long serialVersionUID = -4267474434524183686L;
	/**
	 * 用户ID
	 */
	private String usrId;
	
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	private String usrName;
	private String usrPwd;
	private String usrEmail;
	private String usrPhone;
	private String usrStatus="1";
	private String usrType="1";
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public String getUsrEmail() {
		return usrEmail;
	}
	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}
	public String getUsrPhone() {
		return usrPhone;
	}
	public void setUsrPhone(String usrPhone) {
		this.usrPhone = usrPhone;
	}
	public String getUsrStatus() {
		return usrStatus;
	}
	public void setUsrStatus(String usrStatus) {
		this.usrStatus = usrStatus;
	}
	public String getUsrType() {
		return usrType;
	}
	public void setUsrType(String usrType) {
		this.usrType = usrType;
	}
	
	
	

}

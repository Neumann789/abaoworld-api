package com.fz.abaoworld.common;

public enum CommonEnum {
	
	SOURCE_NATIVE("native","原创"),
	
	//状态: w_handle-待处理,p_handle-处理中,handled-已处理
	PRO_W_HANDLE("w_handle","待处理"),
	PRO_P_HANDLE("p_handle","待处理"),
	PRO_HANDLED("handled","已处理"),
	
	;
	
	private String name;
	private String desc;
	
	private CommonEnum() {}
	
	
	private CommonEnum(String name,String desc) {
		this.name = name;
		this.desc = desc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

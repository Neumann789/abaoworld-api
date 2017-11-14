package com.fz.abaoworld.service.dto.req;

public class QueryProListDTO {
	/**
	 * 当前页码
	 */
	private int pageNo;
	/**
	 * 每页容量
	 */
	private int pageSize;
	
	/**
	 * 起始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;
	
	/**
	 * 问题编号
	 */
	private String proId;
	
	/**
	 * 问题类型
	 */
	private String proType;
	
	/**
	 * 问题标题
	 */
	private String proTitle;
	
	/**
	 * 问题内容
	 */
	private String proContent;
	
	/**
	 * 会员编号
	 */
	private String memberId;
	
	/**
	 * 问题等级
	 */
	private String proDegree;

	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public String getProContent() {
		return proContent;
	}

	public void setProContent(String proContent) {
		this.proContent = proContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProDegree() {
		return proDegree;
	}

	public void setProDegree(String proDegree) {
		this.proDegree = proDegree;
	}
	
	

}

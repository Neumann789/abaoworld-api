package com.fz.abaoworld.service.dto.rsp;

import java.util.List;

import com.fz.abaoworld.dal.entity.ProblemEntity;

public class QueryProListRsp {
	
	/**
	 * 当前页码
	 */
	private int pageNo;
	/**
	 * 每页容量
	 */
	private int pageSize;
	
	/**
	 * 返回总条数
	 */
	private int total;
	
	/**
	 * 返回结果集
	 */
	private List<ProblemEntity> prolist;


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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<ProblemEntity> getProlist() {
		return prolist;
	}

	public void setProlist(List<ProblemEntity> prolist) {
		this.prolist = prolist;
	}
	
	
	
}

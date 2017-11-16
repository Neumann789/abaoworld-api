package com.fz.abaoworld.service.dto.rsp;

import java.util.List;

/**
 * 分页响应基类
 * @author fanghuabao
 *
 */
public class PageRsp<Entity> {
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
	
	private List<Entity> list;

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

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
	}
	
	
}

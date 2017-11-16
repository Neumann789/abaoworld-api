package com.fz.abaoworld.service.dto.rsp;

import java.util.List;

import com.fz.abaoworld.dal.entity.ProblemEntity;

@SuppressWarnings("all")
public class QueryProListRsp extends PageRsp{
	
	
	/**
	 * 返回结果集
	 */
	private List<ProblemEntity> prolist;

	public List<ProblemEntity> getProlist() {
		return prolist;
	}

	public void setProlist(List<ProblemEntity> prolist) {
		this.prolist = prolist;
	}
	
	
	
}

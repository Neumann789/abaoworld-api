package com.fz.abaoworld.service;

import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.dal.entity.ProblemEntity;
import com.fz.abaoworld.service.dto.req.ProblemDTO;
import com.fz.abaoworld.service.dto.req.QueryProListDTO;
import com.fz.abaoworld.service.dto.rsp.QueryProListRsp;

public interface ProblemService {
	
	public BaseRsp addPro(ProblemDTO dto);
	
	public BaseRsp<QueryProListRsp> queryProList(QueryProListDTO dto);
	
	public BaseRsp<ProblemEntity> queryProById(Long proId);

}

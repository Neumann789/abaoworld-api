package com.fz.abaoworld.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.RspCodeEnum;
import com.fz.abaoworld.dal.dao.ProblemDao;
import com.fz.abaoworld.dal.entity.ProblemEntity;
import com.fz.abaoworld.service.ProblemService;
import com.fz.abaoworld.service.dto.req.ProblemDTO;
import com.fz.abaoworld.service.dto.req.QueryProListDTO;
import com.fz.abaoworld.service.dto.rsp.QueryProListRsp;

@Service
@SuppressWarnings("all")
public class ProblemServiceImpl implements ProblemService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProblemDao problemDao;
	
	/**
	 * 
	 * 添加问题
	 * @see com.fz.abaoworld.service.ProblemService#addPro(com.fz.abaoworld.service.dto.req.ProblemDTO)
	 * 1 入参校验
	 * 2 dto转entity
	 * 3 执行insert操作
	 * 4 返回结果
	 */
	@Override
	public BaseRsp addPro(ProblemDTO dto) {
		
		logger.info("请求参数：{}",JSON.toJSONString(dto));
		
		ProblemEntity record = null;
		
		try {
			
			record = dto2Entity(dto);
			
			problemDao.insert(record);
			
		} catch (Exception e) {
			
			logger.error("添加问题异常",e);
			
			return BaseRsp.returnFail();
			
		}
		
		return BaseRsp.returnSuccess();
	}
	
	/**
	 * 
	 * queryProList:查询问题集. <br/>
	 *
	 * @return
	 */
	public BaseRsp<QueryProListRsp> queryProList(QueryProListDTO dto){
		logger.info("请求参数：{}",JSON.toJSONString(dto));
		QueryProListRsp queryProListRsp = new QueryProListRsp();
		BaseRsp<QueryProListRsp> baseRsp = new BaseRsp<>(RspCodeEnum.SUCCESS,queryProListRsp); 
		Map<String,Object> queryMap = new HashMap<>();
		List<ProblemEntity> list = new ArrayList<>();
		try {
			queryMap.put("proTitle", dto.getProTitle());
			queryMap.put("proContent", dto.getProContent());
			queryMap.put("memberId", dto.getMemberId());
			queryMap.put("proDegree", dto.getProDegree());
			queryMap.put("proType", dto.getProType());
			queryMap.put("proId", dto.getProId());
			queryMap.put("startTime", dto.getStartTime());
			queryMap.put("endTime", dto.getEndTime());
			queryMap.put("start", (dto.getPageNo()-1)*dto.getPageSize());
			queryMap.put("end", dto.getPageNo()*dto.getPageSize());
			int total = problemDao.queryProListTotalCount(queryMap);
			if(total>0){
				list = problemDao.queryProList(queryMap);
			}
			queryProListRsp.setPageNo(dto.getPageNo());
			queryProListRsp.setPageSize(dto.getPageSize());
			queryProListRsp.setProlist(list);
			queryProListRsp.setTotal(total);
		} catch (Exception e) {
			return BaseRsp.returnFail();
		}
		
		return baseRsp;
	}
	
	
	/**
	 * 
	 * queryProList:查询问题集. <br/>
	 *
	 * @return
	 */
	public BaseRsp<ProblemEntity> queryProById(Long proId){
		logger.info("请求参数：proId={}",proId);
		BaseRsp<ProblemEntity> baseRsp = new BaseRsp<>(RspCodeEnum.SUCCESS); 
		ProblemEntity entity = null;
		try {
			entity = problemDao.selectByPrimaryKey(proId);
			if(entity!=null){
				baseRsp.setBody(entity);
			}
		} catch (Exception e) {
			return BaseRsp.returnFail();
		}
		
		return baseRsp;
	}
	
	
	private ProblemEntity dto2Entity(ProblemDTO dto){
		ProblemEntity record = new ProblemEntity();
		record.setMemberId("test001");
		record.setProTitle(dto.getProTitle());
		record.setProDegree(dto.getProDegree());
		record.setProType(dto.getProType());
		record.setProContent(dto.getProContent());
		return record;
	}

}

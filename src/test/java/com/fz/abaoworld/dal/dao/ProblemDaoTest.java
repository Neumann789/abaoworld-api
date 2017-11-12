package com.fz.abaoworld.dal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fz.abaoworld.dal.entity.ProblemEntity;

public class ProblemDaoTest extends BaseDaoTest{
	
	@Autowired
	private ProblemDao problemDao;
	
	@Test
	public void insert(){
		//System.out.println("ProblemDaoTest.insert");
		ProblemEntity record = new ProblemEntity();
		record.setMemberId("test001");
		record.setProTitle("why?");
		record.setProDegree("A");
		record.setProType("tech");
		record.setProContent("I do not know!");
		problemDao.insert(record);
	}
	
	@Test
	public void queryProList(){
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("proTitle", "wh");
		queryMap.put("startTime", "20171108000000");
		queryMap.put("endTime", "20181108000000");
		queryMap.put("start", 0);
		queryMap.put("end", 100);
		
		List<ProblemEntity> list = problemDao.queryProList(queryMap);
		
		logger.info("返回结果:{}",JSON.toJSONString(list));
	}
	
	@Test
	public void queryProListTotalCount(){
		Map<String,Object> queryMap = new HashMap<>();
		queryMap.put("proTitle", "wh");
		queryMap.put("startTime", "20171108000000");
		queryMap.put("endTime", "20181108000000");
		queryMap.put("start", 0);
		queryMap.put("end", 100);
		
		int total = problemDao.queryProListTotalCount(queryMap);
		
		logger.info("返回结果:{}",total);
	}
	
	
	

}
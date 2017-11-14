package com.fz.abaoworld.dal.dao;

import java.util.List;
import java.util.Map;

import com.fz.abaoworld.dal.entity.ProblemEntity;

public interface ProblemDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProblemEntity record);

    int insertSelective(ProblemEntity record);

    ProblemEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProblemEntity record);

    int updateByPrimaryKeyWithBLOBs(ProblemEntity record);

    int updateByPrimaryKey(ProblemEntity record);
    
    List<ProblemEntity> queryProList(Map<String,Object> queryMap);
    
    int queryProListTotalCount(Map<String,Object> queryMap);
}
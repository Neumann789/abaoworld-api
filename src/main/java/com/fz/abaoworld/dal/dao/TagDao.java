package com.fz.abaoworld.dal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fz.abaoworld.dal.entity.TagEntity;

public interface TagDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(TagEntity record);

    int insertSelective(TagEntity record);

    TagEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagEntity record);

    int updateByPrimaryKey(TagEntity record);
    
    List<TagEntity> selectAllTags();
    
    int selectAllTagsTotal();
    
    List<TagEntity> selectTagByIds(@Param("ids")String ids);
}
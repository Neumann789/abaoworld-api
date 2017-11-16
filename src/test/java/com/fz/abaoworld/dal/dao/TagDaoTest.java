package com.fz.abaoworld.dal.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fz.abaoworld.dal.entity.TagEntity;

public class TagDaoTest extends BaseDaoTest{
	
	@Autowired
	private TagDao tagDao;
	
	@Test
	public void insert(){
		TagEntity record = new TagEntity();
		record.setTagName("java");
		record.setRemark("java");
		record.setPriority(0);
		tagDao.insert(record);
	}
	
	@Test
	public void selectAllTags(){
		List<TagEntity> list = tagDao.selectAllTags();
		logger.info("返回结果:{}",JSON.toJSONString(list));
	}
	
	@Test
	public void selectAllTagsTotal(){
		int result = tagDao.selectAllTagsTotal();
		logger.info("返回结果:{}",result);
	}

}

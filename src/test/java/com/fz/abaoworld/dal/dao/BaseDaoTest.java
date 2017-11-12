package com.fz.abaoworld.dal.dao;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dal.xml","classpath:spring/spring-placeholder.xml"})

public class BaseDaoTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
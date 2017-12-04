package com.trh.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations= {"classpath:config/spring/*.xml"})
public class BaseServiceTest extends AbstractJUnit4SpringContextTests{

}

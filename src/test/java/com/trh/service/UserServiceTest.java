package com.trh.service;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.trh.enity.Result;
import com.trh.enity.User;


public class UserServiceTest extends BaseServiceTest{
	
	@Resource(name="userServiceImpl")
	UserService userService;
	
	@Test
	public void testQueryUser(){
		Result<User> result   = userService.queryUser("123");
		User user = result.getOther();
		
//		Assert.assertEquals("is right", 1, user.getAge());
	}

}

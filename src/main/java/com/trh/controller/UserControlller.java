package com.trh.controller;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trh.enity.Result;
import com.trh.enity.User;
import com.trh.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControlller {
	
	private static final Logger log = Logger.getLogger(UserControlller.class);
	
	@Resource(name="userServiceImpl")
	UserService userService;
	
	@RequestMapping("/info/{uid}")
	public @ResponseBody Result<User> queryUser(@PathVariable String uid){
		log.info("query user controller...");
		
		return userService.queryUser(uid);
	}
	
	@RequestMapping("/info2/{uid}")
	public @ResponseBody Result<User> queryUser2(@PathVariable String uid){
		log.info("query user controller...");
		
		return userService.queryUser2(uid);
	}
	
	
	
	@RequestMapping("/edit")
	public Result<User> eidtUser(User user){
		
		return userService.eidtUser(user);
		
	}
	
	

}

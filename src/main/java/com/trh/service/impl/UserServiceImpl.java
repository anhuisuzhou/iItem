package com.trh.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trh.dao.UserDao;
import com.trh.enity.Result;
import com.trh.enity.User;
import com.trh.service.UserService;

@Service
@Qualifier("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDaoImpl")
	UserDao userDao;

	@Override
	public Result<User> queryUser(String uid) {

		Result<User> result = new Result<User>();

		User user = userDao.queryUser(uid);

		result.setCode("0");
		result.setMessage("ok");
		result.setOther(user);

		return result;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public Result<User> eidtUser(User user) {
		Result<User> result = new Result<User>();

		int count = userDao.editUser(user);

		if (true) {
			throw new RuntimeException("xxxxxxxxxx");
		}

		result.setCode("0");
		result.setMessage("ok");
		result.setOther(user);
		return result;
	}

	public void abc() {

	}

	@Override
	public Result<User> queryUser2(String uid) {
		Result<User> result = new Result<User>();
		
		User param = new User();
		param.setIsAbc(false);

		User user = userDao.queryUser2(param);

		result.setCode("0");
		result.setMessage("ok");
		result.setOther(user);

		return result;
	}

	public static void main(String[] args) {
		System.out.println();
	}

}

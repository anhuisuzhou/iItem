package com.trh.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trh.dao.BaseDao;
import com.trh.dao.UserDao;
import com.trh.enity.User;

@Repository
@Qualifier("userDaoImpl")
public class UserDaoImpl implements UserDao{
	
	@Resource(name="baseDao")
	private BaseDao baseDaoImpl;

	@Override
	public User queryUser(String uid) {
		return (User)baseDaoImpl.queryForObject("user.queryUser", uid);
	}
	

	@Override
	public int editUser(User user) {
		int cnt = baseDaoImpl.update("user.editUser", user);
		
		return cnt;
	}
	
	public static void main(String[] args) {
	}


	@Override
	public User queryUser2(User param) {
		return (User)baseDaoImpl.queryForObject("user.queryUser2", param);
	}

}

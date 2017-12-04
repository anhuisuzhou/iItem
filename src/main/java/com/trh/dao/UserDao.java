package com.trh.dao;

import com.trh.enity.User;

public interface UserDao {

	User queryUser(String uid);

	int editUser(User user);

	User queryUser2(User param);

}

package com.trh.service;

import com.trh.enity.Result;
import com.trh.enity.User;

public interface UserService {


	Result<User> queryUser(String uid);

	Result<User> eidtUser(User user);

	Result<User> queryUser2(String uid);

}

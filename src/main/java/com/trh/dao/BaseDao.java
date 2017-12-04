package com.trh.dao;

import java.util.List;

public interface BaseDao {
	
	public Object queryForObject(String sql,Object param);
	public List queryForList(String sql,Object param);
	public int update(String sql,Object param);

}

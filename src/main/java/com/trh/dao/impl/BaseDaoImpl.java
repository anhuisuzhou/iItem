package com.trh.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.trh.dao.BaseDao;

public class BaseDaoImpl extends SqlMapClientDaoSupport implements BaseDao{
	
	private SqlMapClientFactoryBean sqlMapClient;
	private DataSource datasource;
	

	public void setSqlMapClient(SqlMapClientFactoryBean sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}







	public Object queryForObject(String sql,Object param){
		return this.getSqlMapClientTemplate().queryForObject(sql, param);
	}

	@Override
	public List queryForList(String sql, Object param) {
		return this.getSqlMapClientTemplate().queryForList(sql, param);
	}

	

	@Override
	public int update(String sql, Object param) {
			return this.getSqlMapClientTemplate().update(sql, param);
	}
	
}

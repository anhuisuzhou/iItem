package com.trh.enity;

import java.io.Serializable;

public class User implements Serializable{
	
	Integer uid;
	String name;
	int age;
	String other;

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", name='" + name + '\'' +
				", age=" + age +
				", other='" + other + '\'' +
				", isAbc=" + isAbc +
				'}';
	}

	Boolean isAbc;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Boolean getIsAbc() {
		return isAbc;
	}
	public void setIsAbc(Boolean isAbc) {
		this.isAbc = isAbc;
	}
	
	
	
	
}

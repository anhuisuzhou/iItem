package com.redis;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.fusesource.hawtbuf.ByteArrayOutputStream;

import redis.clients.jedis.Jedis;

public class JedisClient {
	
	public static Jedis jedis = new Jedis("localhost");
	


	public static void main(String[] args) {
		
		
		testGetCostTime();
		
		
	}
	
	public static void testDeepCopy(){
		
	}
	
	public static void testSetCostTime(){
		long start = System.currentTimeMillis();
		for(int i=0;i<100*10000;i++){
			JedisClient.jedis.set("key"+String.valueOf(i), "00000000000000000000000000000000000000000000000000000000"+String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}
	
	
	public static void testGetCostTime(){
		long start = System.currentTimeMillis();
		
		Object result = JedisClient.jedis.mget("key*");
		System.out.println(result);
		
		
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}

}

/**
 *2017-10-5trh
 */
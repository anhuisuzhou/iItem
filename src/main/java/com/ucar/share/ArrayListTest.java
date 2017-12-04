package com.ucar.share;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayListTest {
	
	public static void main(String[] args) {
		System.out.println("-------------test begin----------");
		ExecutorService threadPool = Executors.newFixedThreadPool(20);
		final ArrayList<Car> list = new ArrayList();
		for(int i=1;i<100;i++){
			Car carx = new Car("ford"+i,1);
			list.add(carx);
		}
		
		
		
		for (int i = 0; i < 100; i++) {  
		threadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				ArrayList<Car > list2 = (ArrayList<Car>) list.clone();
				
//				Car car2 = (Car) list.get(0);
//				car2.setName("bmw");
//				car2.setPrice(Integer.valueOf(2));
//				System.out.println(car2.getName());
//				for(Car carx : list){
//					
//				}
//				for(Car carx : list){
//					if(list.size()  > 88){
//						list.remove(list.size()-5); 
//						break;
//					}
//				}
				
				
				Car car2 = (Car) list2.get(0);
				car2.setName("bmw");
				car2.setPrice(Integer.valueOf(2));
				System.out.println(car2.getName());
				for(Car carx : list2){
					
				}
				for(Car carx : list2){
					if(list.size()  > 88){
						list2.remove(list2.size()-5); 
						break;
					}
				}
				
				
			}
		});}
		
		System.out.println("-------------test end----------");
	}
	
	
}

class Car{
	public Car(String name,Integer price){
		this.name = name;
		this.price = price;
	}
	String name;
	Integer price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}



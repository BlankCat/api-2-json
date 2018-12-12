package com.blankcat.api;

import java.util.Random;


public class Test {

//	 private static int rand1_5()//产生随机数1-5  
//     {  
//         Random ran = new Random();  
//         return ran.Next(1, 6);//返回大于等于1但小于6的整数  
//           
//     }  
	 
	private static ThreadLocal<Integer> instance = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		int size=9;
		//获取随机数
//		System.out.println(new Random().nextInt(2));
//		System.out.println(new Random().nextInt(Integer.MAX_VALUE%3));
//		System.out.println(Integer.MAX_VALUE);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				instance.set(1999);
				System.out.println("------");
				System.out.println(instance.get());
				System.out.println("<------");
				instance.remove();
				System.out.println(instance.get());
				
			}
		}).start();
		
		
		
	}
}

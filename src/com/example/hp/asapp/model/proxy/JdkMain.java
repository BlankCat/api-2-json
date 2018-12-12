package com.example.hp.asapp.model.proxy;

import java.lang.reflect.Proxy;

/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: 动态代理测试类
 */
public class JdkMain {
	 public static void main(String[] args) {
	        Greeting hello=new SayHello();
	        Greeting shakeHands=new ShakeHands();
	        
	       
	        //jdk动态代理
	        JdkProxy dynamicProxy=new JdkProxy(hello);
	        Greeting target=(Greeting) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
	                hello.getClass().getInterfaces(), dynamicProxy);
	        target.doGreet();
	        System.out.println();          
	        
	    }    
}

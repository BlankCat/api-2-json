package com.example.hp.asapp.model.proxy;
/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: 静态代理测试类
 */
public class StaticMain {
	 public static void main(String[] args) {
	        Greeting hello=new SayHello();
	        Greeting shakeHands=new ShakeHands();
	        
	        //静态代理
	        GreetStaticProxy staticHelloProxy=new GreetStaticProxy(hello);
	        staticHelloProxy.doGreet();
	        System.out.println();
	        GreetStaticProxy shakeHandsProxy=new GreetStaticProxy(shakeHands);
	        shakeHandsProxy.doGreet();
	    }    
}

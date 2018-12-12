package com.example.hp.asapp.model.proxy;
/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: 被代理对象
 */
public class SayHello implements Greeting {

    @Override
    public void doGreet() {
        System.out.println("Greeting by say 'hello' .");
    }

}
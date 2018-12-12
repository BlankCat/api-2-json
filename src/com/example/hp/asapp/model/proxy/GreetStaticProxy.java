package com.example.hp.asapp.model.proxy;
/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: 
 */
public class GreetStaticProxy implements Greeting {

    private Greeting hello;//被代理对象
    public GreetStaticProxy(Greeting hello){
        this.hello=hello;
    }
    
    @Override
    public void doGreet() {
        before();//执行其他操作
        this.hello.doGreet();//调用目标方法
        after();//执行其他操作
    }

    public void before(){
        System.out.println("[StaticProxy] Come to someone.");
    }
    public void after(){
        System.out.println("[StaticProxy] Back to his own corner");
    }
}

package com.example.hp.asapp.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: JDK动态代理
 */
public class JdkProxy implements InvocationHandler {

    private Object target;
    
    public JdkProxy(Object obj){
        this.target=obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        
        Object result=null;
        before();
        result=method.invoke(target, args);
        after();
        return result;
    }

    
    public void before(){
        System.out.println("[JdkProxy] Come to someone.");
    }
    public void after(){
        System.out.println("[JdkProxy] Back to his own corner");
    }
}

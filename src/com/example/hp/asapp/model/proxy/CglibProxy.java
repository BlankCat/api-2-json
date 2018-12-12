package com.example.hp.asapp.model.proxy;//package com.example.hp.asapp.model.proxy;
//
//import java.lang.reflect.Method;
//
///**
// * @author: zhang jian feng
// * @date: 2018年8月24日 
// * @Description: CGLIB动态代理
// */
//public class CglibProxy implements MethodInterceptor {
//
//    public static CglibProxy proxy=new CglibProxy();
//    private CglibProxy(){}
//    
//    public static CglibProxy getInstance(){
//        return proxy;
//    }
//    
//    public <T> T getProxy(Class<T> cls){
//        return (T) Enhancer.create(cls, this);
//    }
//    
//    @Override
//    public Object intercept(Object obj, Method method, Object[] arg,
//            MethodProxy proxy) throws Throwable {
//        Object result=null;
//        try {
//            before();
//            result= proxy.invokeSuper(obj, arg);
//            after();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public void before(){
//        System.out.println("[cglib] Come to someone.");
//    }
//    public void after(){
//        System.out.println("[cglib] Back to his own corner.");
//    }
//}
//
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        
//        //cglib代理
//        Greeting targetProxy=CglibProxy.getInstance().getProxy(SayHello.class);
//        targetProxy.doGreet();
//        System.out.println();
//        
//        CglibProxy.getInstance().getInstance().getProxy(KissHello.class).doGreet();
//        
//               
//    }    
//
//}
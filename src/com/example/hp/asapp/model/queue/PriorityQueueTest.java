package com.example.hp.asapp.model.queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author: zhang jian feng
 * @date: 2018年8月24日 
 * @Description: 
 */
public class PriorityQueueTest {
	static final PriorityQueue<Integer> queue=new PriorityQueue<>();
    /**
     * 向队列中插入元素
     * @param number
     */
//    public void add(int number){
//    	synchronized(this){
//    		if(!queue.contains(number)){
//                System.out.println(Thread.currentThread()+"："+number);
//                queue.add(number);
//            }
//    	}
//        
//    }   
    
    public synchronized void add(int number){
    	
    		if(!queue.contains(number)){
                System.out.println(Thread.currentThread()+"："+number);
                queue.add(number);
            }
        
    }   


public static void main(String[] args) throws InterruptedException {
    final PriorityQueueTest qt=new PriorityQueueTest();
        final Random r=new Random();
        Thread t1=new Thread(){
            public void run(){
                System.out.println("t1开始运行...");
                for(int i=0;i<10;i++){
                    qt.add(r.nextInt(10));
                }
            }
        };
        Thread t2=new Thread(){
            public void run(){
                System.out.println("t2开始运行...");
                for(int i=0;i<10;i++){
                    qt.add(r.nextInt(10));
                }
            }
        };
        Thread t3=new Thread(){
            public void run(){
                System.out.println("t3开始运行...");
                for(int i=0;i<10;i++){
                    qt.add(r.nextInt(10));
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("------ 运行结果 ---------");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}

package com.example.hp.asapp.model;

import java.util.Random;

public class RandomUtil {

    public static int random_i(int i){//只会返回[0,i)
    	if (i == 0) {
			return 0;
		}
    	return new Random().nextInt(i);
    }
    
    public static void main(String[] args) {
		System.out.println(random_i(5));;
	}
}

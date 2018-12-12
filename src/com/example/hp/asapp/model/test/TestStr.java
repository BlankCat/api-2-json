package com.example.hp.asapp.model.test;

public class TestStr {

	public static void main(String[] args) {
		
		String a = "a";
		String b = "b";
		String ab = a+b;
		String c = "ab";
		String d = new String("ab");
//		System.out.println(c == d);//false
//		System.out.println(ab=="ab");//false
//		System.out.println(ab == c);//false
//		System.out.println(ab==d);//false
		
		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(ab);
//		System.out.println(d);
		System.out.println(ab.getClass()+"@"+ab.hashCode());
		System.out.println(c.getClass()+"@"+c.hashCode());
		System.out.println(d.getClass()+"@"+d.hashCode());
		System.out.println("ab".getClass()+"@"+"ab".hashCode());
		System.out.println(ab.intern());
		System.out.println(d.intern());
		System.out.println(ab.intern()=="ab");//true
		System.out.println(d.intern()==c);//true
		
		
	}

}

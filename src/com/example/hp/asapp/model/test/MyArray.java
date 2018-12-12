package com.example.hp.asapp.model.test;

public class MyArray {

	private long[] arr;
	private int element;
	public MyArray(){
		arr = new long[50];
	}
	
	public MyArray(int size){
		arr = new long[size];
	}
	
	private void insert(long insertKey){
		arr[element] = insertKey;
		element++;
	}
	
	private void insert2(long insertKey){
		int i;
		for (i  = 0; i < element; i++) {
			if(arr[i]>insertKey)
				break;
		}
		for(int j=i;j<element;j++){
			arr[j]=arr[j+1];
		}
		arr[i] = insertKey;
		element++;
	}
	
	public int find(long findKey){
		int i;
		for ( i= 0; i < element; i++) {
			if(arr[i]==findKey)
				break;
		}
		if(i==element){
			return -1;
		}
		return i;
	}
	
	public void delete(long deleteKey){
		if(-1==find(deleteKey)){
			return;
		}
		int deletePos = find(deleteKey);
		for (int i = element; i < deletePos; i--) {
			arr[i]=arr[i+1];
		}
		
		element --;
		
	}
	
	
	public void selectSort(){
		int min;
		long tmp;
		for (int i = 0; i <element-1; i++) {
			min = i;
			for (int j = i; j < element-1; j++) {
				if(arr[j]<arr[i]){
					min = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		
	}
	
	
	public void bumbSort(){
		long tmp;
		for (int i = 0; i <element-1; i++) {
			for (int j = 0; j < element-1-i; j++) {
				if(arr[j]>arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
//	public int find(long i){
//		int min;
//		int max;
//		int mid;
//		
//		for (int j = 0; j < element; j++) {
//			
//		}
//	}
	
}

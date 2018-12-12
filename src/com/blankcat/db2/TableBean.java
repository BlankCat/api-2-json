package com.blankcat.db2;
/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 
 */
public enum TableBean {
	 	USER_INFO("com.blankcat.db2.UserInfo");
     
	    private String value;
	     
	    private TableBean(String value){
	        this.value = value;
	    }
	     
	    public String getValue(){
	        return value;
	    }
	    @Override
	    public String toString() {
	            return value;              
	    }
	     
	    public static void main(String[] args){
	       System.out.println(TableBean.USER_INFO);
	    }
	    
}

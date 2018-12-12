package com.blankcat.db2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 
 * https://www.cnblogs.com/zhangfei/p/4146272.html
 */
public class ConnectToMySQL {
	 private DBInfo dbInfo;

	    private Connection conn = null;

	    private Statement stmt = null;
	    
	    public ConnectToMySQL(){
	        dbInfo = new DBInfo();
	    }    

	    public DBInfo getDbInfo() {
	        return dbInfo;
	    }

	    public void setDbInfo(DBInfo dbInfo) {
	        this.dbInfo = dbInfo;
	    }

	    public void connect() {
	        this.close();    
	        this.connectMySQL();
	    }

	    public synchronized void close() {
	        try {
	            if (stmt != null) {
	                stmt.close();
	                stmt = null;
	            }
	            if (conn != null) {
	                conn.close();
	                conn = null;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private synchronized void connectMySQL() {
	        try {
	            Class.forName(dbInfo.getDriver()).newInstance();
	            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"
	                    + dbInfo.getHost() + "/" + dbInfo.getDataBase() +"?useUnicode=true&characterEncoding=utf-8", dbInfo.getUser(),dbInfo.getPwd());
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    private void statement() {
	        if (conn == null) {
	            this.connectMySQL();
	        }
	        try {
	            stmt = (Statement) conn.createStatement();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private ResultSet resultSet(String sql) {
	        ResultSet rs = null;
	        if (stmt == null) {
	            this.statement();
	        }
	        try {
	            rs = stmt.executeQuery(sql);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }
	    
	    private void executeUpdate(String sql){
	        if (stmt == null) {
	            this.statement();
	        }
	        try {
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            System.out.println(sql);
	            e.printStackTrace();
	        }
	    }

	    public List<Object> query(String tableInfo, String sql) {
	        List<Object> list = new ArrayList<Object>();        
	        ResultSet rs = this.resultSet(sql);        
	        try {
	            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
	            int cc = md.getColumnCount();
	            while (rs.next()) {    
	                Object object = this.getBeanInfo(tableInfo);
	                for (int i = 1; i <= cc; i++) {
	                    String cn = md.getColumnName(i);     
	                    if(null==rs.getObject(cn))
	                    	break;
	                    this.reflectSetInfo(object, this.changeColumnToBean(cn,"set"), rs.getObject(cn));
	                }    
	                list.add(object);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    public void insert(String table, Object object){        
	        String sql = "";
	        try {
	            this.getMetaData(table);
	            ResultSetMetaData md = MetaData.metaData.get(table);            
	            int cc = md.getColumnCount();
	            String insertColumn = "";
	            String insertValue = "";
	            for (int i = 2; i <= cc; i++) {
	                String cn = md.getColumnName(i);                
	                Object gValue = this.reflectGetInfo(object, this.changeColumnToBean(cn,"get"));
	                if(gValue.getClass().getSimpleName().equals("String")){
	                    gValue = "\""+gValue+"\"";
	                }
	                if("".equals(insertColumn)){
	                    insertColumn += cn;
	                    insertValue += gValue;                    
	                }else{
	                    insertColumn += ","+cn;
	                    insertValue += ","+gValue;
	                }                
	            }
	            sql = "insert into "+table+" ("+insertColumn+") values ("+insertValue+")";            
	            this.executeUpdate(sql);
	        } catch (SQLException e) {            
	            e.printStackTrace();
	        }        
	    } 
	    
	    private void getMetaData(String table){        
	        if(!MetaData.metaData.containsKey(table)){
	            ResultSet rs = this.resultSet("select * from "+table+" limit 0,1");
	            try {                
	                MetaData.metaData.put(table, (ResultSetMetaData) rs.getMetaData());
	            } catch (SQLException e) {                
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    private Object getBeanInfo(String tableInfo){
	        Object object = null;
	        try {
	            object = Class.forName(tableInfo).newInstance();
	        } catch (InstantiationException e) {            
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {            
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {            
	            e.printStackTrace();
	        }
	        return object;
	    }
	    
	    private void reflectSetInfo(Object object, String methodName, Object parameter){
	        try {    
	            Class<? extends Object> ptype = parameter.getClass();            
	            if(parameter.getClass().getSimpleName().equals("Integer")){
	                ptype = int.class;
	            }
	            Method method = object.getClass().getMethod(methodName, ptype);            
	            method.invoke(object, parameter);                                
	        } catch (SecurityException e) {            
	            e.printStackTrace();
	        } catch (NoSuchMethodException e) {            
	            e.printStackTrace();
	        } catch (IllegalArgumentException e) {            
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {            
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {            
	            e.printStackTrace();
	        }
	    }
	    
	    private Object reflectGetInfo(Object object, String methodName){
	        Object value = null;        
	        try {
	            Method method = object.getClass().getMethod(methodName);            
	            Object returnValue = method.invoke(object);
	            if(returnValue!=null){
	                value = returnValue.toString();
	            }else{
	                value = "";
	            }
	        } catch (SecurityException e) {            
	            e.printStackTrace();
	        } catch (NoSuchMethodException e) {            
	            e.printStackTrace();
	        } catch (IllegalArgumentException e) {            
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {            
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {            
	            e.printStackTrace();
	        }
	        return value;    
	    }
	    
	    private String columnToBean(String column){        
	        if(column.contains("_")){
	            int index = column.indexOf("_");
	            String beanName = column.substring(0, index)
	                             +column.substring(index+1, index+2).toUpperCase()
	                             +column.substring(index+2, column.length());            
	            return beanName;
	        }        
	        return column;
	    }
	    
	    private String changeColumnToBean(String column, String ext){
	        String[] col = column.split("_");
	        for (int i = 0; i < col.length; i++) {
	            column = this.columnToBean(column);
	        }
	        column =column.replaceFirst(column.substring(0, 1), column.substring(0, 1).toUpperCase());
	        column = ext+column;
	        return column;
	    }

	    public static void main(String[] args) throws SQLException {
	    	
	        ConnectToMySQL c = new ConnectToMySQL();
	        c.connect();
	        table_user_info(c);
	        c.close();
	    }

		
	    
	    
		@SuppressWarnings("unchecked")
		public static <T> List<T> convert(List<?>list, Class<T> clazz){
			return (List<T>)list;
		}
		
	    /**
	     * List<Object>强制转换为List<String> 等
	     * List<Object> object是不允许直接转成 List<String> 类型的
		       转换方法：List<String> strs = (List<String>)(List)object
	     * convert 泛型类型转换
	     */
		private static void table_user_info(ConnectToMySQL c) {
			// TODO Auto-generated method stub
//			  for(int i=0;i<10;i++){
//		        	 UserInfo vo = new UserInfo();
//		        	 vo.setId(i);
//		        	 vo.setTestName("user"+i);
////		        	 vo.setTestAge(3*i+"");
//		        	 vo.setTestAge(null);
//		        	 vo.setTestHeight("17"+i+"cm");
//		        	 c.insert("user_info", vo);
//		        }
		        List<Object> list = c.query(TableBean.USER_INFO.toString(), "select * from user_info");
		        System.out.println(list.size());
		        if(null!=list&&list.size()>0){
//		        	List<UserInfo> userList =(List<UserInfo>)(List) list;
		        	List<UserInfo> userList = convert(list, UserInfo.class);
		        	for (UserInfo userInfo : userList) {
						System.out.println(userInfo.toString());
					}
		        	
		        }
		        
		}
	
		
		
}

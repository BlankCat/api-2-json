package com.blankcat.mysql;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import com.mysql.jdbc.Connection;
/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 批量添加数据
 * https://blog.csdn.net/wjlwangluo/article/details/78267693
 */
public class MysqlBatchUtil {
	 private String sql="INSERT INTO db_test (param1,param2,param3,param4,param5) VALUES (?,?,?,?,?)";  
	    private String charset="utf-8";  
	    private String connectStr="jdbc:mysql://localhost:3306/test";
	    private String username="root";  
	    private String password="root";  
	    private void doStore() throws ClassNotFoundException, SQLException, IOException {  
	        Class.forName("com.mysql.jdbc.Driver");  
	        connectStr += "?useServerPrepStmts=false&rewriteBatchedStatements=true";//此处是测试高效批次插入，去掉之后执行时普通批次插入
	        Connection conn = (Connection) DriverManager.getConnection(connectStr, username,password);  
	        conn.setAutoCommit(false); // 设置手动提交  
	        int count = 0;  
	        PreparedStatement psts = conn.prepareStatement(sql);  
	        String line = null;  
	        Date begin=new Date();
	        for(int i=0;i<=100000;i++){
	            psts.setString(1, i+"param1");  
	            psts.setString(2, i+"param2");  
	            psts.setString(3, i+"param3");  
	            psts.setString(4, i+"param4");  
	            psts.setString(5, i+"param5");  
	            psts.addBatch();          // 加入批量处理  
	            count++;      
	        }  
	        psts.executeBatch(); // 执行批量处理  
	        conn.commit();  // 提交  
	        Date end=new Date();
	        System.out.println("数量="+count);  
	        System.out.println("运行时间="+(end.getTime()-begin.getTime()));
	        conn.close();  
	    }  
	    public static void main(String[] args) {
	        try {
	            new MysqlBatchUtil().doStore();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}


//TODO sql 脚本

//CREATE TABLE `db_test` (
//		  `param1` varchar(20) DEFAULT NULL,
//		  `param2` varchar(20) DEFAULT NULL,
//		  `param3` varchar(20) DEFAULT NULL,
//		  `param4` varchar(20) DEFAULT NULL,
//		  `param5` varchar(20) DEFAULT NULL
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8;


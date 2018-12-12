package com.blankcat.mysql;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.mysql.jdbc.Statement;

/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 保存json到数据库
 */
public class SaveJson2DB {

//	public static void main(String[] args) {
////		String source=jsonObj.get("source").toString().replaceAll("\"", "\\\" ");
//	}
//	 public static String StringFilter(String str) throws PatternSyntaxException {
//	     // 清除掉所有特殊字符,只允许汉字字母数字和某些常见符号出现
//	     String regEx = "[^0-9a-zA-Z\u4e00-\u9fa5~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]+";
//	     Pattern p = Pattern.compile(regEx);
//	     Matcher m = p.matcher(str);
//	     return m.replaceAll(" ").trim().replaceAll("s+", " ");
//	 }
//	 
//	 public static void insertMicroblogs(String uid, String mid, String time,String geo,String source,
//	 String repost,String comment,String attitude,String text,int flag,Statement statement) throws Exception {
//	     if (uid == null) return;
//	     String sql = "insert into data2016.microblog values(\"" + mid+  "\",\"" + uid +  "\",\"" + time
//	         +  "\",\"" + geo+  "\",\"" + source +  "\",\"" +repost +  "\",\"" + comment +  "\",\"" + attitude
//	         +  "\",\"" + text+ "\"," + flag + ")";
//	     String selectsql = "select count(*) from data2016.microblog where uid = \""+ uid+ "\" and mid=\"" + mid + "\"";
//	 
//	     try {
//	         ResultSet rset = statement.executeQuery(selectsql);
//	         int rowCount = 0; //记录查询结果记录数
//	         if(rset.next()) {
//	             rowCount=rset.getInt(1);
//	         }
//	         if(rowCount == 0){
//	             statement.execute(sql);
//	         }
//	 
//	     } catch (Exception e) {
//	         pErrorUser.println("microblog:"+uid);
//	 //      System.out.println(sql);
//	         e.printStackTrace();
//	         return;
//	     }
//	 }
//	 public static void readUserMicroblogs() throws Exception{
//	     File file = new File("data/source/first/microblogs/microblogs12.txt");
//	     BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
//	     BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// 用5M的缓冲读取文本文件  
//	 
//	     String line = "";
//	     int count = 0;
//	     while((line = reader.readLine()) != null){
//	         count++;
//	         JSONObject blogObject = new JSONObject(line);
//	         String uid = blogObject.getString("uid");
//	         String microblogs = blogObject.getString("microblogs");
//	         JSONArray microblogsArray = new JSONArray(microblogs);
//	         int size = microblogsArray.length();
//	 //      System.out.println("Size:" + size);
//	         for (int i = 0; i < size; i++) {
//	                       JSONObject jsonObj = microblogsArray.getJSONObject(i);
//	               String mid=jsonObj.get("mid").toString();
//	               String created_at=jsonObj.get("created_at").toString();
//	               String geo=StringFilter(jsonObj.get("geo").toString().replaceAll("\"", " "));
//	               String source=jsonObj.get("source").toString().replaceAll("\"", " ");
//	               String reposts_count=jsonObj.get("reposts_count").toString();
//	               String comments_count=jsonObj.get("comments_count").toString();
//	               String attitudes_count=jsonObj.get("attitudes_count").toString();
//	               String text;
//	               int flag;
//	               if(jsonObj.has("retweeted_status")){
//	                   flag=1;
//	                   String retweet = jsonObj.get("retweeted_status").toString();
//	                   JSONObject weibo = new JSONObject(retweet);
//	                   text=StringFilter(weibo.get("text").toString().replaceAll("\"", " "));
//	               }else{
//	                   flag=0;
//	                   text=StringFilter(jsonObj.get("text").toString().replaceAll("\"", " "));
//	               }
//	               insertMicroblogs(uid,mid,created_at,geo,source,reposts_count,comments_count,attitudes_count,text,flag,statement);
//	 
//	             }
//	 
//	             if(count%50==0){
//	                 System.out.print(count +"...");
//	             }
//	             if(count%1000==0){
//	                 System.out.println();
//	             }
//	         }
//	 }
	 
}

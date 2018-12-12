package com.blankcat.api;

import com.google.gson.Gson;
import com.tadu.android.model.json.RetrofitResult;

import java.io.*;

/**
 * 
 * 相同点：都是根据JSON数据创建相应的类
       不同点：
	    1.调用方式区别
	    谷歌：方法都是非静态的，需要先创建对象，再去调用
	    阿里：方法都是静态的，直接用类调用，不需要创建对象
	    2.方法区别：
	    谷歌：fromJson（参数1，参数2）
	    阿里：JSON.parseXX（参数1，参数2）
	        具体是parseObject（）还是parseArray（），根据需要定
 * @author HP
 * https://www.bbsmax.com/A/l1dyPmD65e/
 * Java 文件操作 :系统找不到指定的路径
 * 当你创建文件时，首先应该创建文件的父目录（除非你手动创建过了父目录）。
 * 也就是这样写创建多级目录的文件：
 * https://blog.csdn.net/qq_33678838/article/details/78029812
 *
 */
public class TaDuApi {
	//E:\other\api
	 private  static  final String localPath ="E:\\other\\api\\ci\\";
	 public static void main(String[] args) {
	        Gson gson = new Gson();
//	        Result json = new Result();
//	        json.setCode(100);
//	        json.setMessage("success ...");
	        /**获取用户列表接口*/
//	        String jsonStr = personListInterface(gson, json);
	        /***获取任务接口**/
//	        String jsonStr = getGroupTaskListInterface(gson, json);
	        /***字体列表接口**/
	        RetrofitResult datas = new RetrofitResult();
	        datas.setCode(100);
	        datas.setMessage("success");
//	        String jsonStr = ApiUtils.selectDoctorOff(gson, datas);
	        String jsonStr = ApiUtils.sign(gson, datas);
	        saveDataToFile("dailyAttendance520","sign",jsonStr);
	        System.out.println(jsonStr);
	    }


	    /*********************************************************************************/
	    
	    private static void saveDataToFile(String module,String fileName,String data) {
	        BufferedWriter writer = null;
	        File file = new File(localPath+module+"\\"+ fileName + ".json");
	        if(!file.exists()){
	            try {
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        try {
	            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
	            writer.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                if(writer != null){
	                    writer.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("�ļ�д��ɹ���");
	    }
	    
	    private static void saveDataToFile(String fileName,String data) {
	        BufferedWriter writer = null;
	        File file = new File("d:\\api\\xrtn-doctor\\v2\\"+ fileName + ".json");
	        //����ļ������ڣ����½�һ��
	        if(!file.exists()){
	            try {
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        //д��
	        try {
	            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
	            writer.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                if(writer != null){
	                    writer.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("�ļ�д��ɹ���");
	    }
	    private String getDatafromFile(String fileName) {

	        String Path="d:\\" + fileName+ ".json";
	        BufferedReader reader = null;
	        String laststr = "";
	        try {
	            FileInputStream fileInputStream = new FileInputStream(Path);
	            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
	            reader = new BufferedReader(inputStreamReader);
	            String tempString = null;
	            while ((tempString = reader.readLine()) != null) {
	                laststr += tempString;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return laststr;
	    }
	}

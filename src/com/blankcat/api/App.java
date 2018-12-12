package com.blankcat.api;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.example.hp.asapp.model.BaseBean;
import com.example.hp.asapp.model.Person;
import com.example.hp.asapp.model.font.SettingFontListBean;
import com.example.hp.asapp.model.font.SettingFontModel;
import com.example.hp.asapp.model.json.result.Result;
import com.example.hp.asapp.model.jyf.OrderBean;
import com.example.hp.asapp.model.jyf.selectDoctorOff;
import com.example.hp.asapp.model.task.Task;
import com.example.hp.asapp.model.task.TaskData;
import com.google.gson.Gson;
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
 *
 */
public class App {
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
	        BaseBean datas = new BaseBean();
	        datas.setCode("0");
	        datas.setMsg("success");
	        String jsonStr = selectDoctorOff(gson, datas);
	        saveDataToFile("user","selectDoctorOrderList",jsonStr);
	        System.out.println(jsonStr);
	    }
	 private static String selectDoctorOrderList(Gson gson, BaseBean json) {
//	    	SettingFontListBean datas = new SettingFontListBean();
	    	List<OrderBean> list = new ArrayList<OrderBean>();
	        for (int i=0;i<20;i++){
	        	OrderBean model = new OrderBean();
	        	model.init(i);
	        	list.add(model);
	        }
	        json.setResults(list);
	        return gson.toJson(json);
	    }
	 private static String selectDoctorOff(Gson gson, BaseBean json) {
//	    	SettingFontListBean datas = new SettingFontListBean();
		 List<selectDoctorOff> list = new ArrayList<selectDoctorOff>();
		 for (int i=0;i<10;i++){
			 selectDoctorOff model = new selectDoctorOff();
			 model.setOffDay("200"+(int)Math.random()*9+"-0"+i+"-17");
			 model.setTypeId((int)Math.random()*2);
			 list.add(model);
		 }
		 json.setResults(list);
		 return gson.toJson(json);
	 }
	 

	    /**
	     * �û��б�ӿ�
	     * @param gson
	     * @param json
	     * @return
	     */
	    private static String getFontListInterface(Gson gson, Result json) {
	    	SettingFontListBean datas = new SettingFontListBean();
	    	List<SettingFontModel> fontList = new ArrayList<SettingFontModel>();
	        for (int i=0;i<10;i++){
	        	SettingFontModel fontModel = new SettingFontModel();
	        	fontModel.init(i);
	        	fontList.add(fontModel);
	        }
	        datas.setFontList(fontList);
	        json.setData(datas);
	        return gson.toJson(json);
	    }
	    /**
	     * �û��б�ӿ�
	     * @param gson
	     * @param json
	     * @return
	     */
	    private static String getGroupTaskListInterface(Gson gson, Result json) {
	    	TaskData datas = new TaskData();
	    	ArrayList<Task> growthList = new ArrayList<Task>();
	    	ArrayList<Task> userDateTasksList = new ArrayList<Task>();
	    	ArrayList<Task> weekList = new ArrayList<Task>();
	    	for (int i=0;i<10;i++){
	    		Task growth = new Task();
	    		growth.init(i,"growth");
	    		
	    		Task userDate = new Task();
	    		userDate.init(i,"userDate");
	    		
	    		Task week = new Task();
	    		week.init(i,"week");
	    		
	    		growthList.add(growth);
	    		userDateTasksList.add(userDate);
	    		weekList.add(week);
	    		
	    	}
	    	
	    	datas.setGrowthList(growthList);
	    	datas.setUserDateTasksList(userDateTasksList);
	    	datas.setWeekList(weekList);
	    	json.setData(datas);
	    	
	    	return gson.toJson(json);
	    }
	    /**
	     * �û��б�ӿ�
	     * @param gson
	     * @param json
	     * @return
	     */
	    private static String personListInterface(Gson gson, Result json) {
	    	List<Person> list = new ArrayList<Person>();
	    	for (int i=0;i<10;i++){
	    		list.add(new Person(i,"zjf",i,i));
	    	}
	    	json.setData(list);
	    	return gson.toJson(json);
	    }

	    /*************************************д�ļ�********************************************/
	    
	    private static void saveDataToFile(String module,String fileName,String data) {
	        BufferedWriter writer = null;
	        File file = new File("d:\\api\\xrtn-doctor\\v2\\"+module+"\\"+ fileName + ".json");
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

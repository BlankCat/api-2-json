package com.blankcat.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author: zhang jian feng
 * @date: 2018年7月5日 
 * @Description: 
 */
public class FormatJson {
	/**
	 * 缩进
	 * @param indentCount
	 * @return
	 */
	private static String indentStrBuild(int indentCount){
		String strTemp = "";
		for(int i=0;i<indentCount;i++){
			strTemp += "    ";
		}
		return strTemp;
	}
	
	/**
	 * 打印初始结构是map的Java对象
	 * @param map
	 * @param indentCount
	 * @return
	 */
	private static String indentShowMap(Map<String, Object> map,int indentCount){
		Iterator iterator =  map.keySet().iterator();
		String strTemp = "{\n";
		while (iterator.hasNext()) {
			String keyName = (String) iterator.next();
			Object value = map.get(keyName);
			if(value.getClass().toString().indexOf("java.lang.Double")!=-1){
				strTemp +=  indentStrBuild(indentCount+1)+keyName+" : "+value.toString()+",\n";
			}
			else if(value.getClass().toString().indexOf("java.lang.String")!=-1){
				strTemp +=  indentStrBuild(indentCount+1)+keyName+" : "+value.toString()+",\n";
			}
			else if(value.getClass().toString().indexOf("com.google.gson.internal.LinkedTreeMap")!=-1){
				strTemp += indentStrBuild(indentCount+1)+keyName+" : "+ indentShowMap((Map<String, Object>) value,indentCount+1)+",\n";
			}
			else if(value.getClass().toString().indexOf("List")!=-1){
				strTemp += indentStrBuild(indentCount+1)+keyName+" : "+ indentShowList((List) value,indentCount+1)+",\n";
			}
		}
		if(-1 != strTemp.lastIndexOf(",\n")){
			if(strTemp.length()==(strTemp.lastIndexOf(",\n")+2)){
				strTemp = strTemp.substring(0, strTemp.lastIndexOf(",\n"))+"\n";
			}
		}
		strTemp += ""+indentStrBuild(indentCount)+"}";
		return strTemp;
	}
	
	/**
	 * 打印初始结构是list的Java对象
	 * @param list
	 * @param indentCount
	 * @return
	 */
	private static String indentShowList(List list,int indentCount){
		String strTemp = "[\n";
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object value = iterator.next();
			if(value.getClass().toString().indexOf("java.lang.Double")!=-1){
				strTemp += indentStrBuild(indentCount+1)+value+",\n";
			}
			else if(value.getClass().toString().indexOf("java.lang.String")!=-1){
				strTemp += indentStrBuild(indentCount+1)+value+",\n";
			}
			else if(value.getClass().toString().indexOf("com.google.gson.internal.LinkedTreeMap")!=-1){
				strTemp += indentStrBuild(indentCount+1)+indentShowMap((Map<String, Object>) value,indentCount+1)+",\n";
			}
			else if(value.getClass().toString().indexOf("List")!=-1){
				strTemp += indentStrBuild(indentCount+1)+indentShowList((List) value,indentCount+1)+",\n";
			}
		}
		if(-1 != strTemp.lastIndexOf(",\n")){
			if(strTemp.length()==(strTemp.lastIndexOf(",\n")+2)){
				strTemp = strTemp.substring(0, strTemp.lastIndexOf(",\n"))+"\n";
			}
		}
		strTemp += ""+indentStrBuild(indentCount)+"]";
		return strTemp;
	}
	
	/**
	 * 测试gson
	 */
	public static void testGson(){
		System.out.println("-----------toJson result，Java对象编码成 json字符串--------------");
		Map<String, Object> params = new HashMap<String, Object>();  
		params.put("code", 200);  
		params.put("message", "消息内容");
 
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("intValue", 201);  
		data.put("stringValue", "key2_value");
 
		ArrayList list1 = new ArrayList();
		list1.add("element1");
		list1.add("element2");
		list1.add("element3");
		data.put("list1",list1);
		
		Map<String, Object> map2= new HashMap<String, Object>();
		map2.put("map2_intValue", 201);  
		map2.put("map2_stringValue", "key2_value");
		data.put("map2", map2);
		
		params.put("data", data);
		
		String jsonStr = new Gson().toJson(params);
		System.out.println(jsonStr);
 
		System.out.println("-----------fromJson result，json字符串解码成Java对象--------------");
 
		Map<String, Object> result = new Gson().fromJson(jsonStr,new TypeToken<Map<String,Object>>(){}.getType());
		
		// 缩进打印对象树
		System.out.println(indentShowMap(result,0));
		
		System.out.println(result.get("code"));
		System.out.println(result.get("code").getClass());
 
		System.out.println(result.get("message"));
		System.out.println(result.get("message").getClass());
 
		Map<String, Object> resultData = (Map<String, Object>) result.get("data");
		System.out.println("---------intValue----------------");
		System.out.println(resultData.get("intValue"));
		System.out.println(resultData.get("intValue").getClass());
 
		System.out.println("---------stringValue----------------");
		System.out.println(resultData.get("stringValue"));
		System.out.println(resultData.get("stringValue").getClass());
 
		System.out.println("---------LinkedTreeMap----------------");
		System.out.println(result.get("data").getClass());
 
		System.out.println("---------ArrayList----------------");
		ArrayList resultArrayList = (ArrayList) resultData.get("list1");
		Iterator iterator = resultArrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(resultData.get("list1").getClass());
	}
	
	public static void main(String[] args) {
		testGson();
	}

}

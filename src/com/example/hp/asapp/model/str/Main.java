package com.example.hp.asapp.model.str;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author: zhang jian feng
 * @date: 2018年8月29日 
 * @Description: 
 */
public class Main {

	public static void main(String[] args) {
//		String s = new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
//        // 分词器构造函数三个参数，第一个是待分隔的字符串，第二个为分隔字符串，以字符为分隔单位（比如the，可能匹配到e，就会分隔），
//        //第三个参数说明是否要把分割字符串作为标记返回
//        StringTokenizer st = new StringTokenizer(s, "the", true);
//        System.out.println("Token Total:" + st.countTokens());
//        while (st.hasMoreElements()) {
//            System.out.println(st.nextToken());
//        }
		
		//解析url
		String url="http://qsn.zfwx.com/wxqt/goQsnCategoryPage.do?type=1&domain=15&rq=1040677&jd=1040694&fl=1040674";
		System.out.println(url.substring(0,url.lastIndexOf("?")));
		HashMap<String, String> map=parseParam(url);
		for(Map.Entry<String,String> entry:map.entrySet()){
			System.out.println(entry.getKey()+"----------"+entry.getValue());
		}
		
		System.out.println(map.size());
		
	}
	
	private static HashMap<String, String> parseParam(String lastUrl) {
		HashMap<String, String> params = new HashMap<String, String>();
		String url = lastUrl.substring(lastUrl.lastIndexOf("?")+1);
		System.out.println(url);
		StringTokenizer st=new StringTokenizer(url, "&");
		while(st.hasMoreTokens()){
			try {
				StringTokenizer mSt = new StringTokenizer(st.nextToken(),"=");
				params.put(mSt.nextToken(),mSt.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return params;
	}
}

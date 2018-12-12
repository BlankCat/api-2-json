package com.example.hp.asapp.model.font;

import com.example.hp.asapp.model.RandomUtil;

public class SettingFontModel {
	    private int id; //字体id
	    private int taskId;//任务id
	    private String name;//字体名字
	    private String fileUrl;//字体url
	    private String path;//字体路径
	    private int fileLength;//字体长度
	    private String image;//字体图片
	    private int isCharged;
	    private int price;//字体价格
	    private int sale;
	    //0 已购买 1 免费  2 限免 3 特价 4 收费
	    ////////////////////////////////////
	    public String defPath="http://10.2.2.39:18080/apk/tadu.apk";
	    public void init(int i){
	    	this.setId(i);
	    	this.setTaskId(i);
	    	this.setName("字体名字"+i);
	    	this.setFileUrl("http://10.2.2.39:18080/apk/tadu"+i+".apk");
	    	this.setPath("path"+i);
	    	this.setFileLength(1000);
	    	this.setImage("http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png");
	    	this.setIsCharged(RandomUtil.random_i(4));
	    }
	    public void init(int i,String tag){
	    	
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getTaskId() {
			return taskId;
		}
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFileUrl() {
			return fileUrl;
		}
		public void setFileUrl(String fileUrl) {
			this.fileUrl = fileUrl;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public int getFileLength() {
			return fileLength;
		}
		public void setFileLength(int fileLength) {
			this.fileLength = fileLength;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getIsCharged() {
			return isCharged;
		}
		public void setIsCharged(int isCharged) {
			this.isCharged = isCharged;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getSale() {
			return sale;
		}
		public void setSale(int sale) {
			this.sale = sale;
		}
		@Override
		public String toString() {
			return "SettingFontModel [id=" + id + ", taskId=" + taskId + ", name=" + name + ", fileUrl=" + fileUrl
					+ ", path=" + path + ", fileLength=" + fileLength + ", image=" + image + ", isCharged=" + isCharged
					+ ", price=" + price + ", sale=" + sale + "]";
		}
	    
}

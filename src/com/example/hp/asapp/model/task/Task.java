package com.example.hp.asapp.model.task;

import java.io.Serializable;
import java.util.Random;

public class Task implements Serializable {

    /**
     * @Version 3.6.0 新增任务副标题字段及是否是正在加载状态
     */
    private String viceTitle;
    private boolean isProgress;
    public boolean getProgress() {
        return isProgress;
    }
    public void setProgress(boolean isLoading) {
        this.isProgress = isLoading;
    }


    private int id;// 任务id
    private String taskName;//任务名称
    private String taskType;//任务类型：1是成长类型，0是每日任务
    private String finishCondition;//完成任务条件说明
    private String url;//前往的url
    private int score;//积分
    private int growth;//成长值
    private int tadou;//塔豆
    private int taquan;
    private int taskStatus;//任务状态（0是完成，未领取；1是未完成，未领取，2是完成，已领取）
    private String finishProgress;
    private int responseDataType;

    public void init(int i,String tag){
    	setId(i);//任务id
    	setTaskName("任务名称："+tag+i);//任务名称
    	setTaskType(random2()+"任务类型...");//任务类型
    	setFinishCondition(tag+"任务说明条件...");//任务说明条件
    	setUrl("www.baidu.com");//任务的url
    	setScore(getScoreRandom(i));//获取积分
    	setGrowth(getGrowthRandom(i));//成长值
    	setTadou(getTadouRandom(i));//塔豆
    	setTaquan(getTaquanRandom(i));//塔圈
    	setTaskStatus(random_i(3));//任务状态
    	setFinishProgress(tag+"完成进度...");//完成进度
    	setResponseDataType(random2());//完成进度
    	
    	
    	
    }
    private int getGrowthRandom(int i){//只会返回0/1
    	return new Random().nextInt(i*2+5);
    }
    private int getTaquanRandom(int i){//只会返回0/1
    	return new Random().nextInt(i*2+5);
    }
    private int getTadouRandom(int i){//只会返回0/1
    	return new Random().nextInt(i*1000+5);
    }
    private int getScoreRandom(int i){//只会返回0/1
    	return new Random().nextInt(i*10+5);
    }
    
    private int random2(){//只会返回0/1
    	return new Random().nextInt(2);
    }
    private int random_i(int i){//只会返回[0,i)
    	if (i == 0) {
			return 0;
		}
    	return new Random().nextInt(i);
    }
    
    public void init(){
    	
    }
    public void init(int i){
    	
    }
    

    public int getTaquan() {
        return taquan;
    }

    public void setTaquan(int taquan) {
        this.taquan = taquan;
    }

    public int getResponseDataType() {
        return responseDataType;
    }

    public boolean isMonthCardTask(){
        return responseDataType == 1;
    }

    public void setResponseDataType(int responseDataType) {
        this.responseDataType = responseDataType;
    }

    public String getFinishProgress() {
        return finishProgress;
    }
    public void setFinishProgress(String finishProgress) {
        this.finishProgress = finishProgress;
    }

    public String getViceTitle() {
        return viceTitle;
    }
    public void setViceTitle(String viceTitle) {
        this.viceTitle = viceTitle;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskType() {
        return taskType;
    }
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    public String getFinishCondition() {
        return finishCondition;
    }
    public void setFinishCondition(String finishCondition) {
        this.finishCondition = finishCondition;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getGrowth() {
        return growth;
    }
    public void setGrowth(int growth) {
        this.growth = growth;
    }
    public int getTadou() {
        return tadou;
    }
    public void setTadou(int tadou) {
        this.tadou = tadou;
    }
    public int getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

}
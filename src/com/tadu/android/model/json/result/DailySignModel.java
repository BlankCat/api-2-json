package com.tadu.android.model.json.result;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zjf
 * @Date: 2018/7/23
 * @Desc: 新签到模型列表【展示7天】
 */
public class DailySignModel implements Serializable{

    private Integer id;
    private Integer giftType;
    private Integer dayNum;
    private Integer taquan;
    private Integer growth;
    private Integer score;
    private String recommendedTicket;
    private Integer zoneId;
    private Integer platformId;
    private String packageName;
    private long dateLong;

    /**扩充字段*/
    private String dayStr;//日期
    private int giftIconState;//[未签，已签，默认]根据giftType，giftIconState状态找对应的图标

    public void init(int i){
        setId(i);
        setGiftType(6);
        setDayNum(3*i+5);
        setTaquan(10*i+5);
        setGrowth(10*i+5);
        setScore(10*i+5);
        setRecommendedTicket("recomand"+i);
        setZoneId(10);
        setPlatformId(1);
        setGiftIconState(1);
        setDateLong(new Date().getTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiftType() {
        return giftType;
    }

    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public Integer getTaquan() {
        return taquan;
    }

    public void setTaquan(Integer taquan) {
        this.taquan = taquan;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRecommendedTicket() {
        return recommendedTicket;
    }

    public void setRecommendedTicket(String recommendedTicket) {
        this.recommendedTicket = recommendedTicket;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getDateLong() {
        return dateLong;
    }

    public void setDateLong(long dateLong) {
        this.dateLong = dateLong;
    }

    public String getDayStr() {
        return dayStr;
    }

    public void setDayStr(String dayStr) {
        this.dayStr = dayStr;
    }

    public int getGiftIconState() {
        return giftIconState;
    }

    public void setGiftIconState(int giftIconState) {
        this.giftIconState = giftIconState;
    }


}

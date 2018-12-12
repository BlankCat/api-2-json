package com.tadu.android.model.json.result;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjf
 * @Date: 2018/7/24
 * @Desc: 日签到成功弹窗模型
 */
public class DailySignDialogModel {


    /**显示当天签到和第二天签到的数据，后台约定size=2*/
    private List<DailySignModel> dailyAttendanceSets;
    private int haveSignTimes;//已签到几天了
    private String name;//书包名称
    private int offsetGiftDay; //连续签到天数
    /**书包*/
    private ArrayList<BookInfo> books;//书包
    /**5.40扩充字段*/
    private boolean isMember=true;//——是否是会员，true：是会员  false:不是会员
    /**会员关系*/
    private CheckInMemberRelation memberRelation;



    public List<DailySignModel> getDailyAttendanceSets() {
        return dailyAttendanceSets;
    }

    public void setDailyAttendanceSets(List<DailySignModel> dailyAttendanceSets) {
        this.dailyAttendanceSets = dailyAttendanceSets;
    }

    public int getHavesignTimes() {
        return haveSignTimes;
    }

    public void setHavesignTimes(int havesignTimes) {
        this.haveSignTimes = havesignTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BookInfo> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookInfo> books) {
        this.books = books;
    }

    public int getOffsetGiftDay() {
        return offsetGiftDay;
    }

    public void setOffsetGiftDay(int offsetGiftDay) {
        this.offsetGiftDay = offsetGiftDay;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public CheckInMemberRelation getMemberRelation() {
        return memberRelation;
    }

    public void setMemberRelation(CheckInMemberRelation memberRelation) {
        this.memberRelation = memberRelation;
    }
}

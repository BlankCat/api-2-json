package com.tadu.android.model.json.result;



import java.io.Serializable;
import java.util.List;

/**
 * @author: zjf
 * @Date: 2018/7/23
 * @Desc: 获取签到接口数据
 */
public class DailySignResult implements Serializable{
    private int haveSignTimes;//已签到几天了
    /**签到数据*/
    private List<DailySignModel>  dailyAttendanceSets;
    /**运营数据*/
    private List<DailyOperation> contents;//运营位列表数据
    private DailyOperationMore dailyOperatingBit;//运营位更多数据

    /**扩充字段*/
    private Integer state;//是否已经签到【0：未签/1：已签】
    private Integer offsetGiftDay; //再签几天有礼

    /**5.40扩充字段*/
    private boolean isMember=true;//——是否是会员，true：是会员  false:不是会员
    /**会员关系*/
    private CheckInMemberRelation memberRelation;


    public int getHavesignTimes() {
        return haveSignTimes;
    }

    public void setHavesignTimes(int haveSignTimes) {
        this.haveSignTimes = haveSignTimes;
    }

    public List<DailySignModel> getDailyAttendanceSets() {
        return dailyAttendanceSets;
    }

    public void setDailyAttendanceSets(List<DailySignModel> dailyAttendanceSets) {
        this.dailyAttendanceSets = dailyAttendanceSets;
    }
    public Integer getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getOffsetGiftDay() {
        return offsetGiftDay;
    }

    public void setOffsetGiftDay(int offsetGiftDay) {
        this.offsetGiftDay = offsetGiftDay;
    }

    public List<DailyOperation> getContents() {
        return contents;
    }

    public void setContents(List<DailyOperation> contents) {
        this.contents = contents;
    }

    public DailyOperationMore getDailyOperatingBit() {
        return dailyOperatingBit;
    }

    public void setDailyOperatingBit(DailyOperationMore dailyOperatingBit) {
        this.dailyOperatingBit = dailyOperatingBit;
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

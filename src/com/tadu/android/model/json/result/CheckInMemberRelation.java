package com.tadu.android.model.json.result;


/**
 * @author: zjf
 * @Date: 2018/12/11
 * @Desc: 签到提示内容
 */
public class CheckInMemberRelation {
    private String multiple;//——奖励倍数2翻倍
    private String tipContent;//——提示内容//会员:{尊敬的会员，今日签到奖励翻倍}/非会员：{会员签到奖励翻倍}

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getTipContent() {
        return tipContent;
    }

    public void setTipContent(String tipContent) {
        this.tipContent = tipContent;
    }
}

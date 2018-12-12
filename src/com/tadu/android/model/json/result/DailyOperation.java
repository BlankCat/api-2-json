package com.tadu.android.model.json.result;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zjf
 * @Date: 2018/7/23
 * @Desc: 签到运营位数据
 */
public class DailyOperation implements Serializable{
    public void init(int i){
        setImgUrl("www.baidu.com");
        setLinkUrl("www.baidu.com");
    }
    /**
     * 图片地址1
     */
    private String imgUrl;
    /**
     * 跳转地址1
     */
    private String linkUrl;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}

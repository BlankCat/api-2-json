package com.tadu.android.model.json.result;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zjf
 * @Date: 2018/7/23
 * @Desc: 签到运营更多数据
 */
public class DailyOperationMore implements Serializable{
    public void init(int i){
        setContent("运营为更多数据");
        setId(1);
        setModuleName("运营数据");
    }
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 配置内容，json格式
     */
    private String content;
    /**
     * 是否有更多；是否查看更多；1有，0没有
     */
    private Integer haveMore;
    /**
     * 更多链接
     */
    private String moreLinkUrl;

    /**
     * 签到平台
     */
    private Integer platformId;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 创建时间
     */
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHaveMore() {
        return haveMore;
    }

    public void setHaveMore(Integer haveMore) {
        this.haveMore = haveMore;
    }

    public String getMoreLinkUrl() {
        return moreLinkUrl;
    }

    public void setMoreLinkUrl(String moreLinkUrl) {
        this.moreLinkUrl = moreLinkUrl;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

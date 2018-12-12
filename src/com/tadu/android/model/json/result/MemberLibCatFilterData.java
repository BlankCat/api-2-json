package com.tadu.android.model.json.result;

import com.tadu.android.model.json.CategoryFilterTabBean;

import java.util.List;
/**
 * @author: zjf
 * @Date: 2018/12/7
 * @Desc: 会员书库分类数据
 */
public class MemberLibCatFilterData {
    List<CategoryFilterTabBean> firstCatgory;//男生/女生/出版
    List<CategoryFilterTabBean> maleCategories;//男生一级分类
    List<CategoryFilterTabBean> femaleCategories;//女生一级分类
    List<CategoryFilterTabBean> publishCategories;//出版一级分类
    List<String> chars;//字数
    List<CategoryFilterTabBean> bookStatus;//全部/完结连载

    public List<CategoryFilterTabBean> getFirstCatgory() {
        return firstCatgory;
    }

    public void setFirstCatgory(List<CategoryFilterTabBean> firstCatgory) {
        this.firstCatgory = firstCatgory;
    }

    public List<CategoryFilterTabBean> getMaleCategories() {
        return maleCategories;
    }

    public void setMaleCategories(List<CategoryFilterTabBean> maleCategories) {
        this.maleCategories = maleCategories;
    }

    public List<CategoryFilterTabBean> getFemaleCategories() {
        return femaleCategories;
    }

    public void setFemaleCategories(List<CategoryFilterTabBean> femaleCategories) {
        this.femaleCategories = femaleCategories;
    }

    public List<CategoryFilterTabBean> getPublishCategories() {
        return publishCategories;
    }

    public void setPublishCategories(List<CategoryFilterTabBean> publishCategories) {
        this.publishCategories = publishCategories;
    }

    public List<String> getChars() {
        return chars;
    }

    public void setChars(List<String> chars) {
        this.chars = chars;
    }

    public List<CategoryFilterTabBean> getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(List<CategoryFilterTabBean> bookStatus) {
        this.bookStatus = bookStatus;
    }
}

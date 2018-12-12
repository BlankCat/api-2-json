package com.blankcat.api;

import com.google.gson.Gson;
import com.tadu.android.model.json.CategoryFilterTabBean;
import com.tadu.android.model.json.RetrofitResult;
import com.tadu.android.model.json.result.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjf
 * @Date: 2018/12/11
 * @Desc
 */
public class ApiUtils {
    public static String sign(Gson gson, RetrofitResult json) {
        ///ci/dailyAttendance520/sign
        DailySignDialogModel  result = new DailySignDialogModel();
        /**显示当天签到和第二天签到的数据，后台约定size=2*/
         List<DailySignModel> dailyAttendanceSets = new ArrayList<>();
        for (int i=0;i<=1;i++){
            DailySignModel vo = new DailySignModel();
            vo.init(i);
            dailyAttendanceSets.add(vo);
        }
        result.setDailyAttendanceSets(dailyAttendanceSets);
         int haveSignTimes = 3;//已签到几天了
        result.setHavesignTimes(haveSignTimes);
         String name = "zhangjianfeng";//书包名称
        result.setName(name);
         int offsetGiftDay=3; //连续签到天数
        result.setOffsetGiftDay(offsetGiftDay);
        /**书包*/
         ArrayList<BookInfo> books=new ArrayList<>();//书包
        books.add(new BookInfo());
        result.setBooks(books);
        /**5.40扩充字段*/
         boolean isMember=true;//——是否是会员，true：是会员  false:不是会员
        result.setMember(isMember);
        /**会员关系*/
         CheckInMemberRelation memberRelation = new CheckInMemberRelation();
            memberRelation.setMultiple(2+"");
            result.setMemberRelation(memberRelation);

        json.setData(result);
        return gson.toJson(json);
    }
    public static String getSignInfo(Gson gson, RetrofitResult json) {
        ///ci/dailyAttendance520/getSignInfo
        DailySignResult result = new DailySignResult();
         int haveSignTimes=3;//已签到几天了
        result.setHavesignTimes(haveSignTimes);

        /**签到数据*/
         List<DailySignModel>  dailyAttendanceSets = new ArrayList<>();
         for (int i=0;i<=7;i++){
             DailySignModel vo = new DailySignModel();
             vo.init(i);
             dailyAttendanceSets.add(vo);
         }
         result.setDailyAttendanceSets(dailyAttendanceSets);


        /**运营数据*/
         List<DailyOperation> contents = new ArrayList<>();//运营位列表数据
        for (int i=0;i<=7;i++){
            DailyOperation vo = new DailyOperation();
            vo.init(i);
            contents.add(vo);
        }
        result.setContents(contents);


         DailyOperationMore dailyOperatingBit = new DailyOperationMore();//运营位更多数据
        dailyOperatingBit.init(1);
         result.setDailyAttendanceSets(dailyAttendanceSets);
        /**扩充字段*/
         Integer state =0;//是否已经签到【0：未签/1：已签】
         result.setState(state);
         Integer offsetGiftDay = 3; //再签几天有礼
         result.setOffsetGiftDay(offsetGiftDay);

        /**5.40扩充字段*/
         boolean isMember=true;//——是否是会员，true：是会员  false:不是会员
         result.setMember(isMember);

        /**会员关系*/
         CheckInMemberRelation memberRelation = new CheckInMemberRelation() ;
         memberRelation.setMultiple(2+"");
         result.setMemberRelation(memberRelation);

        json.setData(result);
        return gson.toJson(json);
    }






    public static String selectDoctorOff(Gson gson, RetrofitResult json) {

//	    	SettingFontListBean datas = new SettingFontListBean();
        MemberLibCatFilterData result = new MemberLibCatFilterData();

        List<CategoryFilterTabBean> firstCatgory = new ArrayList<>();//男生/女生/出版

        CategoryFilterTabBean bean = new CategoryFilterTabBean();
        bean.setId(98 + "");
        bean.setName("男生");
        firstCatgory.add(bean);
        bean = new CategoryFilterTabBean();
        bean.setId(122 + "");
        bean.setName("女生");
        firstCatgory.add(bean);
        bean = new CategoryFilterTabBean();
        bean.setId(79 + "");
        bean.setName("出版");
        firstCatgory.add(bean);

        List<CategoryFilterTabBean> maleCategories = new ArrayList<>();//男生一级分类
        for(int male=0;male<20;male++){
            CategoryFilterTabBean vo = new CategoryFilterTabBean();
            if(male==0){
                vo.setId(male + "");
                vo.setName("全部");
            }else{
                vo.setId(male + "");
                vo.setName("男生"+male);
            }
            maleCategories.add(vo);
        }

        List<CategoryFilterTabBean> femaleCategories = new ArrayList<>();//女生一级分类
        for(int female=0;female<20;female++){
            CategoryFilterTabBean vo = new CategoryFilterTabBean();
            if(female==0){
                vo.setId(female + "");
                vo.setName("全部");
            }else{
                vo.setId(female + "");
                vo.setName("女生"+female);
            }
            femaleCategories.add(vo);
        }
        List<CategoryFilterTabBean> publishCategories = new ArrayList<>();//出版一级分类
        for(int publish=0;publish<20;publish++){
            CategoryFilterTabBean vo = new CategoryFilterTabBean();
            if(publish==0){
                vo.setId(publish + "");
                vo.setName("全部");
            }else{
                vo.setId(publish + "");
                vo.setName("出版"+publish);
            }
            publishCategories.add(vo);
        }

        List<String> chars = new ArrayList<>();//字数

        List<CategoryFilterTabBean> bookStatus = new ArrayList<>();//全部/完结连载
        CategoryFilterTabBean bs = new CategoryFilterTabBean();
        bs.setId(0 + "");
        bs.setName("全部");
        bookStatus.add(bs);
        bs = new CategoryFilterTabBean();
        bs.setId(122 + "");
        bs.setName("完结");
        bookStatus.add(bs);
        bs = new CategoryFilterTabBean();
        bs.setId(79 + "");
        bs.setName("连载");
        bookStatus.add(bs);

        //------------------------------
        result.setFirstCatgory(firstCatgory);
        result.setMaleCategories(maleCategories);
        result.setFemaleCategories(femaleCategories);
        result.setPublishCategories(publishCategories);
        result.setChars(chars);
        result.setBookStatus(bookStatus);
        json.setData(result);
        return gson.toJson(json);
    }
}

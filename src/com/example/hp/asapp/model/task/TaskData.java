package com.example.hp.asapp.model.task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskData implements Serializable{

	/**
     * 成长任务
     */
    private ArrayList<Task> growthList;//是成长任务数组
    /**
     * 每日任务
     */
    private ArrayList<Task> userDateTasksList;//每日任务数组

    private ArrayList<Task> weekList;


    public ArrayList<Task> getWeekList() {
        return weekList;
    }

    public void setWeekList(ArrayList<Task> weekList) {
        this.weekList = weekList;
    }

    public ArrayList<Task> getGrowthList() {
        return growthList;
    }

    public void setGrowthList(ArrayList<Task> growthList) {
        this.growthList = growthList;
    }

    public ArrayList<Task> getUserDateTasksList() {
        return userDateTasksList;
    }

    public void setUserDateTasksList(ArrayList<Task> userDateTasksList) {
        this.userDateTasksList = userDateTasksList;
    }

}

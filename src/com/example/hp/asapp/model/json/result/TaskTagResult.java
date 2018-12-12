package com.example.hp.asapp.model.json.result;

/**
 * Created by litao on 2016/10/21.
 */
public class TaskTagResult {
    /**鏄惁鏄柊鐢ㄦ埛*/
    public String newUser;
    /**鏄剧ず鍝釜Tab*/
    public String showTab;
    /**娌℃湁棰嗗彇鐨勪换鍔�*/
    public String noFinishTaskTabs;


    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public String getShowTab() {
        return showTab;
    }

    public void setShowTab(String showTab) {
        this.showTab = showTab;
    }

    public String getNoFinishTaskTabs() {
        return noFinishTaskTabs;
    }

    public void setNoFinishTaskTabs(String noFinishTaskTabs) {
        this.noFinishTaskTabs = noFinishTaskTabs;
    }
}

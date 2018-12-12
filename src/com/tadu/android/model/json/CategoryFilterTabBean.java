package com.tadu.android.model.json;

/**
 * Created by litao on 2016/5/18.
 */
public class CategoryFilterTabBean {
    private String id;
    private String name;
    private int type;

    public CategoryFilterTabBean(){

    }

    public CategoryFilterTabBean(String id,String name,int type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

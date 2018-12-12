package com.example.hp.asapp.model;

/**
 * Created by jyf on 17/7/21.
 */

public class BaseBean {
    private String code;
    private String msg;
    private Object results;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}
    
}

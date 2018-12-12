package com.blankcat.db2;
/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 
 */
public class UserInfo {
	private int id;
    
    private String testName;
    
    private String testAge;
    
    private String testHeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestAge() {
        return testAge;
    }

    public void setTestAge(String testAge) {
        this.testAge = testAge;
    }

    public String getTestHeight() {
        return testHeight;
    }

    public void setTestHeight(String testHeight) {
        this.testHeight = testHeight;
    }

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", testName=" + testName + ", testAge=" + testAge + ", testHeight=" + testHeight
				+ "]";
	}    
    
    
    
}

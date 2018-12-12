package com.blankcat.db2;
/**
 * @author: zhang jian feng
 * @date: 2018年9月5日 
 * @Description: 
 * https://www.cnblogs.com/zhangfei/p/4146272.html
 */
public class DBInfo {
private String driver;
    
    private String host;
    
    private String port;
    
    private String user;
    
    private String pwd;
    
    private String dataBase;
    
    public DBInfo(){        
        this.driver = "com.mysql.jdbc.Driver";
        this.host = "localhost";
        this.port = "3306";
        this.user = "root";
        this.pwd = "root";
        this.dataBase = "test";
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }    
}

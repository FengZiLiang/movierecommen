package com.gupt.bigdata.sparkmoviesweb.entity;

public class User {
    private int userid;
    private String username;
    private String password;

    public void setUserid(int userid){
        this.userid=userid;
    }
    public int getUserid(){
        return this.userid;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
}

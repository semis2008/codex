package com.codex.request;

import java.io.Serializable;

/**
 * Created by ningwang4 on 16/9/1.
 */
public class LoginPostReq{

    private String userName;
    private String passWord;

    public LoginPostReq(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

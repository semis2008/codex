package com.codex.request;

/**
 * Created by ningwang4 on 16/9/1.
 */
public class RegistSubmitReq {

    private String userName;
    private String passWord;
    private String phone;

    public RegistSubmitReq(){}

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

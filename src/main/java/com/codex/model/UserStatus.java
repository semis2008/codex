package com.codex.model;

/**
 * Created by ningwang4 on 16/9/2.
 */
public enum UserStatus {
    LIMIT("未激活",0),ACTIVE("已激活",1),DISABLE("禁用",2);
    private String desc;
    private Integer status;

    UserStatus(String desc, Integer status) {
        this.desc = desc;
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

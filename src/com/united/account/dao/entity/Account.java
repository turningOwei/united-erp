package com.united.account.dao.entity;

import java.util.Date;

public class Account {
    private Integer id;

    private Integer corpId;

    private String name;

    private String password;

    private String mobilePhone;

    private String email;

    private Date createDate;

    private Date updateDate;

    private String bizModuleKey;

    public Account(Integer id, Integer corpId, String name, String password, String mobilePhone, String email, Date createDate, Date updateDate, String bizModuleKey) {
        this.id = id;
        this.corpId = corpId;
        this.name = name;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.bizModuleKey = bizModuleKey;
    }

    public Account() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getBizModuleKey() {
        return bizModuleKey;
    }

    public void setBizModuleKey(String bizModuleKey) {
        this.bizModuleKey = bizModuleKey;
    }
}
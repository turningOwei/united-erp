package com.united.account.dao.entity;

import java.util.Date;

public class Account {
    private Integer id;

    private String name;

    private String password;

    private String mobilePhone;

    private String email;

    private Date createDate;

    private Date updateDate;

    public Account(Integer id, String name, String password, String mobilePhone, String email, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
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
}
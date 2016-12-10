package com.united.permission.dao.entity;

public class SysUser {
    private Integer id;

    private String userName;

    private Integer accountId;

    public SysUser(Integer id, String userName, Integer accountId) {
        this.id = id;
        this.userName = userName;
        this.accountId = accountId;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
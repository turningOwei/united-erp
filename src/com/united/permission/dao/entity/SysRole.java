package com.united.permission.dao.entity;

public class SysRole {
    private Integer id;

    private String roleName;

    public SysRole(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
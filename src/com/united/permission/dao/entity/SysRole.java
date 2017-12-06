package com.united.permission.dao.entity;

public class SysRole {
    private Long id;

    private String roleName;

    public SysRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public SysRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
package com.united.permission.dao.entity;

public class CorpModuleRole {
    private Long id;

    private Long corpId;

    private String moduleKey;

    private String roleName;

    private String roleAliasName;

    private String bizSuperadmin;

    private String remark;

    private String description;

    public CorpModuleRole(Long id, Long corpId, String moduleKey, String roleName, String roleAliasName, String bizSuperadmin, String remark, String description) {
        this.id = id;
        this.corpId = corpId;
        this.moduleKey = moduleKey;
        this.roleName = roleName;
        this.roleAliasName = roleAliasName;
        this.bizSuperadmin = bizSuperadmin;
        this.remark = remark;
        this.description = description;
    }

    public CorpModuleRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey == null ? null : moduleKey.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleAliasName() {
        return roleAliasName;
    }

    public void setRoleAliasName(String roleAliasName) {
        this.roleAliasName = roleAliasName == null ? null : roleAliasName.trim();
    }

    public String getBizSuperadmin() {
        return bizSuperadmin;
    }

    public void setBizSuperadmin(String bizSuperadmin) {
        this.bizSuperadmin = bizSuperadmin == null ? null : bizSuperadmin.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package com.united.permission.dao.entity;

public class Resource extends ResourceKey {
    private String text;

    private Integer parentId;

    private String name;

    private String menuUrl;

    private String menuType;

    private String iconCls;

    private Integer isLeaf;

    private String jsClassName;

    private Integer validStatus;

    private String roleKey;

    public Resource(Integer dbId, Integer corpId, String text, Integer parentId, String name, String menuUrl, String menuType, String iconCls, Integer isLeaf, String jsClassName, Integer validStatus, String roleKey) {
        super(dbId, corpId);
        this.text = text;
        this.parentId = parentId;
        this.name = name;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.iconCls = iconCls;
        this.isLeaf = isLeaf;
        this.jsClassName = jsClassName;
        this.validStatus = validStatus;
        this.roleKey = roleKey;
    }

    public Resource() {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getJsClassName() {
        return jsClassName;
    }

    public void setJsClassName(String jsClassName) {
        this.jsClassName = jsClassName == null ? null : jsClassName.trim();
    }

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }
}
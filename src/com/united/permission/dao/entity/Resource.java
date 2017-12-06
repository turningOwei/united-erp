package com.united.permission.dao.entity;

import java.util.List;

public class Resource extends ResourceKey {
    private String text;

    private Long parentId;

    private String name;

    private String menuUrl;

    private String menuType;

    private String iconCls;

    private Integer isLeaf;

    private String jsClassName;

    private Integer validStatus;

    private String moduleKeys;

    private List<Resource> children;



    public Resource(Long dbId, Long corpId, String text, Long parentId, String name, String menuUrl, String menuType, String iconCls, Integer isLeaf, String jsClassName, Integer validStatus, String moduleKeys) {
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
        this.moduleKeys = moduleKeys;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
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

    public String getModuleKeys() {
        return moduleKeys;
    }

    public void setModuleKeys(String moduleKeys) {
        this.moduleKeys = moduleKeys;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }
}
package com.united.permission.dao.entity;

import org.springframework.data.annotation.Transient;

import java.util.List;

public class SysResource {
    private Integer dbId;

    private String text;

    private Integer parentId;

    private String name;

    private String menuUrl;

    private String menuType;

    private String iconCls;

    private Integer isLeaf;

    private String jsPath;

    @Transient
    private List<SysResource> children;

    public SysResource(Integer dbId, String text, Integer parentId, String name, String menuUrl, String menuType, String iconCls, Integer isLeaf, String jsPath) {
        this.dbId = dbId;
        this.text = text;
        this.parentId = parentId;
        this.name = name;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.iconCls = iconCls;
        this.isLeaf = isLeaf;
        this.jsPath = jsPath;
    }

    public SysResource() {
        super();
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
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

    public String getJsPath() {
        return jsPath;
    }

    public void setJsPath(String jsPath) {
        this.jsPath = jsPath == null ? null : jsPath.trim();
    }

    public List<SysResource> getChildren() {
        return children;
    }

    public void setChildren(List<SysResource> children) {
        this.children = children;
    }
}
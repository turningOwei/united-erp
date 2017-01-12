package com.united.permission.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="SYS_RESOURCE")
public class SysResource implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="TEXT")
    private String text;

    @Column(name="PARENT_ID")
    private Long parentId;

    @Column(name="NAME")
    private String name;

    @Column(name="MENU_URL")
    private String menuUrl;

    @Column(name="MENU_TYPE")
    private String menuType;

    @Column(name="ICON_CLS")
    private String iconCls;

    @Column(name="IS_LEAF")
    private Integer isLeaf;

    @Column(name="JS_CLASS_NAME")
    private String jsClassName;

    @Column(name="VALID_STATUS")
    private String validStatus;

    @Column(name="IS_VALID")
    private Boolean isValid;

    @Transient
    private List<SysResource> children;

    public SysResource(){}

    public SysResource(String text, Long parentId, String name, String menuUrl, String menuType, String iconCls, Integer isLeaf, String jsClassName, String validStatus, Boolean isValid) {
        this.text = text;
        this.parentId = parentId;
        this.name = name;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.iconCls = iconCls;
        this.isLeaf = isLeaf;
        this.jsClassName = jsClassName;
        this.validStatus = validStatus;
        this.isValid = isValid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        this.name = name;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
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
        this.jsClassName = jsClassName;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public List<SysResource> getChildren() {
        return children;
    }

    public void setChildren(List<SysResource> children) {
        this.children = children;
    }
}
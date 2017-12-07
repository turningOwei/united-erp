package com.united.permission.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="SYS_RESOURCE")
@Data
public class SysResource implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="oid")
    private Long oid;

    @Column(name="text")
    private String text;

    @Column(name="parent_id")
    private Long parentId;

    @Column(name="name")
    private String name;

    @Column(name="menu_url")
    private String menuUrl;

    @Column(name="menu_type")
    private String menuType;

    @Column(name="icon_cls")
    private String iconCls;

    @Column(name="is_leaf")
    private Integer isLeaf;

    @Column(name="js_class_name")
    private String jsClassName;

    @Column(name="valid_status")
    private String validStatus;

    @Column(name="is_valid")
    private Boolean isValid;

    @Transient
    private List<SysResource> children;

    /**
     * 用于判断当前角色是否有该资源菜单
     */
    @Transient
    private Boolean checkFlag;

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


}
package com.united.permission.dao.entity;

/**
 * Created by turningOwei on 2017/1/9.
 */

import javax.persistence.*;

/**
 * 权限关联资源表
 */
@Entity
@Table(name="SYS_ROLE_RES")
public class SysRoleRes {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="RESOURCE_ID")
    private Long resourceId;


    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=SysResource.class)
    @JoinColumn(name="OID",updatable=false)//指定一个外键，也可以不指定。//nullable=false,
    private SysResource sysResource;

    public SysRoleRes() {
    }

    public SysRoleRes(Long roleId, Long resourceId, SysResource sysResource) {
        this.roleId = roleId;
        this.resourceId = resourceId;
        this.sysResource = sysResource;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public SysResource getSysResource() {
        return sysResource;
    }

    public void setSysResource(SysResource sysResource) {
        this.sysResource = sysResource;
    }

}

package com.united.permission.dao.entity;

/**
 * Created by turningOwei on 2017/1/9.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * 权限关联资源表
 */
@Entity
@Table(name="SYS_ROLE_RES")
public class SysRoleRes {
    @Id
    @SequenceGenerator(name="sequence",sequenceName="SEQ_SYS_ROLE_RES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name="OID")
    private Long oid;

    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="RESOURCE_ID")
    private Long resourceId;

    @Column(name="IS_VALID")
    private Boolean isValid;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,targetEntity=SysResource.class)
    @JoinColumn(name="RESOURCE_ID", insertable=false,updatable=false)
    private SysResource sysResource;

    public SysRoleRes() {
    }

    public SysRoleRes(Long roleId, Long resourceId, Boolean isValid) {
        this.roleId = roleId;
        this.resourceId = resourceId;
        this.isValid = isValid;
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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}

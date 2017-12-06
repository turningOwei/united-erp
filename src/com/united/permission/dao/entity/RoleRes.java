package com.united.permission.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.united.corp.dao.entity.SysDepartment;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by turningOwei on 2017/1/16.
 */

/**
 * 一般角色(非超级)的资源菜单
 */
@Entity
@Table(name="T_ROLE_RES")
public class RoleRes implements Serializable{
    @Id
    @SequenceGenerator(name="sequence",sequenceName="SEQ_T_ROLE_RES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column(name="OID")
    private Long oid;

    @Column(name="CORP_ID")
    private Long corpId;

    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="RESOURCE_ID")
    private Long resourceId;
    //删除标志
    @Column(name="IS_VALID")
    private Boolean isValid;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity=SysResource.class)
    @JoinColumn(name="RESOURCE_ID", insertable=false,updatable=false)
    private SysResource sysResource;


    public RoleRes(){}
    public RoleRes(Long corpId, Long roleId, Long resourceId, Boolean isValid) {
        this.corpId = corpId;
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

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
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

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public SysResource getSysResource() {
        return sysResource;
    }

    public void setSysResource(SysResource sysResource) {
        this.sysResource = sysResource;
    }
}

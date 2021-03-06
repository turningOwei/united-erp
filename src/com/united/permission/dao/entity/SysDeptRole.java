package com.united.permission.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.united.corp.dao.entity.SysDepartment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by turningOwei on 2017/1/10.
 */
@Entity
@Table(name="SYS_DEPT_ROLE")
public class SysDeptRole implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="NAME")
    private String name;

    @Column(name="ALIAS_NAME")
    private String aliasName;

    @Column(name="MEMO")
    private String memo;

    @Column(name="DEPT_ID")
    private Long deptId;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SysRoleRes> sysRoleRes;

    @Column(name="IS_SUPER_ADMIN")
    private Boolean isSuperAdmin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity=SysDepartment.class)
    @JoinColumn(name="DEPT_ID", insertable=false,updatable=false)
    private SysDepartment sysDepartment;

    @Transient
    private String departmentName;

    public SysDeptRole() {
    }


    public SysDeptRole(String name, String aliasName, String memo, Long deptId, List<SysRoleRes> sysRoleRes, Boolean isSuperAdmin) {
        this.name = name;
        this.aliasName = aliasName;
        this.memo = memo;
        this.deptId = deptId;
        this.sysRoleRes = sysRoleRes;
        this.isSuperAdmin = isSuperAdmin;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public List<SysRoleRes> getSysRoleRes() {
        return sysRoleRes;
    }

    public void setSysRoleRes(List<SysRoleRes> sysRoleRes) {
        this.sysRoleRes = sysRoleRes;
    }

    public Boolean getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(Boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    public SysDepartment getSysDepartment() {
        return sysDepartment;
    }

    public void setSysDepartment(SysDepartment sysDepartment) {
        this.sysDepartment = sysDepartment;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

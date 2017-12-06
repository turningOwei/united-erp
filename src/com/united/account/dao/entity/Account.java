package com.united.account.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.united.corp.dao.entity.SysDepartment;
import com.united.permission.dao.entity.SysDeptRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="T_ACCOUNT")
public class Account implements Serializable{
    @Id
    @SequenceGenerator(name="sequence",sequenceName="SEQ_ACCOUNT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="OID")
    private Long oid;

    @Column(name="CORP_ID")
    private Long corpId;

    @Column(name="DEPT_ID")
    private Long deptId;

    @Column(name="DEPT_ROLE_ID")
    private Long deptRoleId;

    @Column(name="NAME")
    private String name;

    @Column(name="PWD")
    private String pwd;

    @Column(name="MOBILE_PHONE")
    private String mobilePhone;

    @Column(name="EMAIL")
    private String email;

    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name="UPDATE_DATE")
    private Date updateDate;


    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,targetEntity=SysDepartment.class)//cascade=CascadeType.ALL,
    @JoinColumn(name="DEPT_ID", referencedColumnName="OID",insertable = false, updatable = false)
    private SysDepartment sysDepartment;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,targetEntity=SysDeptRole.class)//cascade=CascadeType.ALL,
    @JoinColumn(name="DEPT_ROLE_ID", referencedColumnName="OID",insertable = false, updatable = false)
    private SysDeptRole sysDeptRole;

    @Transient
    private String departmentName;

    @Transient
    private String roleName;

    public Account(Long corpId, Long deptId, Long deptRoleId, String name, String pwd, String mobilePhone, String email, Date createDate, Date updateDate, SysDepartment sysDepartment, String departmentName, String roleName) {
        this.corpId = corpId;
        this.deptId = deptId;
        this.deptRoleId = deptRoleId;
        this.name = name;
        this.pwd = pwd;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.sysDepartment = sysDepartment;
        this.departmentName = departmentName;
        this.roleName = roleName;
    }

    public Account() {
        super();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getDeptRoleId() {
        return deptRoleId;
    }

    public void setDeptRoleId(Long deptRoleId) {
        this.deptRoleId = deptRoleId;
    }

    public SysDeptRole getSysDeptRole() {
        return sysDeptRole;
    }

    public void setSysDeptRole(SysDeptRole sysDeptRole) {
        this.sysDeptRole = sysDeptRole;
    }
}
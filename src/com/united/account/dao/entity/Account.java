package com.united.account.dao.entity;


import com.united.corp.dao.entity.SysDepartment;
import com.united.permission.dao.entity.AccountRole;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="T_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="CORP_ID")
    private Long corpId;

    @Column(name="DEPT_ID")
    private Long deptId;

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

    @OneToOne(cascade=CascadeType.ALL,targetEntity=AccountRole.class)
    @JoinColumn(name="OID", referencedColumnName="ACCOUNT_ID",insertable = false, updatable = false)
    private AccountRole accountRole;

    @OneToOne(cascade=CascadeType.ALL,targetEntity=SysDepartment.class)
    @JoinColumn(name="OID", insertable = false, updatable = false)
    private SysDepartment sysDepartment;

    public Account(Long oid, Long corpId,Long deptId, String name, String pwd, String mobilePhone, String email, Date createDate, Date updateDate, String bizModuleKey) {
        this.oid = oid;
        this.corpId = corpId;
        this.deptId = deptId;
        this.name = name;
        this.pwd = pwd;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
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
}
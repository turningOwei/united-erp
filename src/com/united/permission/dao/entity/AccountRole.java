package com.united.permission.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Entity
@Table(name="T_ACCOUNT_ROLE")
public class AccountRole implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="ACCOUNT_ID")
    private Long accountId;

    @Column(name="DEPT_ROLE_ID")
    private Long deptRoleId;

    public AccountRole() {

    }

    public AccountRole(Long accountId, Long deptRoleId) {
        this.accountId = accountId;
        this.deptRoleId = deptRoleId;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDeptRoleId() {
        return deptRoleId;
    }

    public void setDeptRoleId(Long deptRoleId) {
        this.deptRoleId = deptRoleId;
    }
}

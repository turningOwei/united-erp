package com.united.corp.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="T_CORP_DEPT")
public class CorpDept {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="OID")
    private Long oid;

    @Column(name="CORP_ID")
    private Long corpId;

    @Column(name="DEPT_ID")
    private Long deptId;

    @Column(name="IS_VALID")
    private Boolean isValid;


    public CorpDept(Long corpId, Long deptId,Boolean isValid) {
        this.corpId = corpId;
        this.deptId = deptId;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Boolean getIsValid() {
        if(isValid == null)
            return false;
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}
package com.united.corp.dao.entity;

import javax.persistence.*;

/**
 * Created by turningOwei on 2017/1/11.
 */
@Entity
@Table(name="T_COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="CORP_CODE")
    private String corpCode;

    @Column(name="CORP_NAME")
    private String corpName;

    @Column(name="SUPER_ACCOUNT_ID")
    private Long superAccountId;

    @Column(name="SUPER_ACCOUNT_NAME")
    private String superAccountName;

    @Column(name="BIZ_LICENSE")
    private String bizLicense;

    @Column(name="CORP_TELEPHONE")
    private String corpTelephone;

    @Column(name="CORP_MOBILE")
    private String corpMobile;

    @Column(name="CORP_ADDRESS")
    private String corpAddress;

    public Company() {
    }

    public Company(String corpCode, String corpName, Long superAccountId, String superAccountName, String bizLicense, String corpTelephone, String corpMobile, String corpAddress) {
        this.corpCode = corpCode;
        this.corpName = corpName;
        this.superAccountId = superAccountId;
        this.superAccountName = superAccountName;
        this.bizLicense = bizLicense;
        this.corpTelephone = corpTelephone;
        this.corpMobile = corpMobile;
        this.corpAddress = corpAddress;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public Long getSuperAccountId() {
        return superAccountId;
    }

    public void setSuperAccountId(Long superAccountId) {
        this.superAccountId = superAccountId;
    }

    public String getSuperAccountName() {
        return superAccountName;
    }

    public void setSuperAccountName(String superAccountName) {
        this.superAccountName = superAccountName;
    }

    public String getBizLicense() {
        return bizLicense;
    }

    public void setBizLicense(String bizLicense) {
        this.bizLicense = bizLicense;
    }

    public String getCorpTelephone() {
        return corpTelephone;
    }

    public void setCorpTelephone(String corpTelephone) {
        this.corpTelephone = corpTelephone;
    }

    public String getCorpMobile() {
        return corpMobile;
    }

    public void setCorpMobile(String corpMobile) {
        this.corpMobile = corpMobile;
    }

    public String getCorpAddress() {
        return corpAddress;
    }

    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress;
    }
}

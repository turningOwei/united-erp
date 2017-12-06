package com.united.corp.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Entity
@Table(name="SYS_DEPARTMENT")
public class SysDepartment implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name="OID")
    private Long oid;

    @Column(name="NAME")
    private String name;

    @Column(name="BIZ_MODULE_KEY")
    private String bizModuleKey;

    public SysDepartment() {
    }

    public SysDepartment(String name, String bizModuleKey) {
        this.name = name;
        this.bizModuleKey = bizModuleKey;
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

    public String getBizModuleKey() {
        return bizModuleKey;
    }

    public void setBizModuleKey(String bizModuleKey) {
        this.bizModuleKey = bizModuleKey;
    }
}

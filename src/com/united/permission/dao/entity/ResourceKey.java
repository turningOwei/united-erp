package com.united.permission.dao.entity;

public class ResourceKey {
    private Integer dbId;

    private Integer corpId;

    public ResourceKey(Integer dbId, Integer corpId) {
        this.dbId = dbId;
        this.corpId = corpId;
    }

    public ResourceKey() {
        super();
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }
}
package com.united.permission.dao.entity;

public class ResourceKey {
    private Long dbId;

    private Long corpId;

    public ResourceKey(Long dbId, Long corpId) {
        this.dbId = dbId;
        this.corpId = corpId;
    }

    public ResourceKey() {
        super();
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public Long getCorpId() {
        return corpId;
    }

    public void setCorpId(Long corpId) {
        this.corpId = corpId;
    }
}
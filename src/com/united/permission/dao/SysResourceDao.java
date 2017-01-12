package com.united.permission.dao;

import com.united.common.dao.BaseDao;
import com.united.permission.dao.entity.SysResource;

/**
 * Created by turningOwei on 2017/1/9.
 */
public interface SysResourceDao extends BaseDao<SysResource, Long> {
    public SysResource getRootSysource();
}

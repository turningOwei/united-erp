package com.united.permission.dao.impl;

import com.united.common.dao.impl.BaseDaoImpl;
import com.united.permission.dao.SysResourceDao;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.domain.RootNode;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Repository
public class SysResourceDaoImpl extends BaseDaoImpl<SysResource, Long> implements SysResourceDao  {
    @Override
    public SysResource getRootSysource() {
       return this.get(RootNode.getOid());
    }

}

package com.united.permission.dao;

import com.united.common.dao.BaseDao;
import com.united.permission.dao.entity.SysRoleRes;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
public interface SysRoleResDao extends BaseDao<SysRoleRes,Long>{
    List<SysRoleRes> getDeleteList(Long roleId, Long[] resourceIds);

    List<SysRoleRes> getHasList(Long roleId, Long[] resourceIds);

    public void deleteByRoleId(Long roleId);
}

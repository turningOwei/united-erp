package com.united.permission.dao.impl;

import com.united.common.dao.impl.BaseDaoImpl;
import com.united.permission.dao.SysRoleResDao;
import com.united.permission.dao.entity.SysRoleRes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Repository
public class SysRoleResDaoImpl extends BaseDaoImpl<SysRoleRes, Long> implements SysRoleResDao{

    @Override
    public List<SysRoleRes> getDeleteList(Long roleId, Long[] resourceIds) {
        String deleteHql = "from SysRoleRes where roleId=? and resourceId not in (:resourceIds)";
        return getList(deleteHql, roleId, resourceIds);
    }

    @Override
    public List<SysRoleRes> getHasList(Long roleId, Long[] resourceIds) {
        String hasHql = "from SysRoleRes where roleId=? and resourceId in (:resourceIds)";
        return getList(hasHql,roleId,resourceIds);
    }

    private List<SysRoleRes> getList(String hql,Long roleId, Long[] resourceIds){
        return this.getSession().createQuery(hql)
                .setParameter(0, roleId)
                .setParameterList("resourceIds", resourceIds).list();
    }
}

package com.united.permission.dao.impl;

import com.united.common.dao.impl.BaseDaoImpl;
import com.united.permission.dao.SysRoleResDao;
import com.united.permission.dao.entity.SysRoleRes;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Repository
public class SysRoleResDaoImpl extends BaseDaoImpl<SysRoleRes, Long> implements SysRoleResDao{

    /*@Override
    public List<SysRoleRes> getDeleteList(Long roleId, Long[] resourceIds) {
        String deleteHql = "from SysRoleRes where roleId=? and resourceId not in (:resourceIds)";
        return getList(deleteHql, roleId, resourceIds);
    }*/

    @Override
    public List<SysRoleRes> getHasList(Long roleId, Long[] resourceIds) {
        String hasHql = "from SysRoleRes where isValid=? and roleId=? and resourceId in (:resourceIds)";
        return this.getSession().createQuery(hasHql)
                .setParameter(0, true)
                .setParameter(1, roleId)
                .setParameterList("resourceIds", resourceIds).list();
    }


    @Override
    public void deleteByRoleId(Long roleId) {
        String hql = "update SysRoleRes srr set isValid=? where srr.roleId=?";
        this.getSession().createQuery(hql)
                .setParameter(0,false)
                .setParameter(1,roleId)
                .executeUpdate();
    }

    @Override
    public void delete(Long roleId, Long[] resourceIds) {
        String hasHql = "update SysRoleRes set isValid=? where isValid=? and roleId=? and resourceId not in (:resourceIds)";
         this.getSession().createQuery(hasHql)
                 .setParameter(0, false)
                 .setParameter(1, true)
                 .setParameter(2, roleId)
                 .setParameterList("resourceIds", resourceIds).executeUpdate();
    }

    @Override
    public SysRoleRes getEntity(Long roleId, Long resourceId) {
        Map map = new HashMap();
        map.put("roleId",roleId);
        map.put("resourceId",resourceId);
        return this.getEquals(map);
    }

    @Override
    public List<SysRoleRes> getListByRole(Long roleId) {
        Map map = new HashMap<>();
        map.put("roleId",roleId);
        map.put("isValid",true);
        return this.getListEquals(map);
    }
}

package com.united.permission.dao.impl;

import com.united.common.dao.impl.BaseDaoImpl;
import com.united.permission.dao.RoleResDao;
import com.united.permission.dao.entity.RoleRes;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by turningOwei on 2017/1/16.
 */
@Repository
public class RoleResDaoImpl extends BaseDaoImpl<RoleRes,Long> implements RoleResDao {
    @Override
    public void deleteByCorpAndRole(Long corpId, Long roleId) {
        String hql = "update RoleRes rr set rr.isValid=? where rr.corpId=? and rr.roleId=?";
        this.getSession().createQuery(hql)
                .setParameter(0, false)
                .setParameter(1, corpId)
                .setParameter(2, roleId)
                .executeUpdate();

    }

    @Override
    public List<RoleRes> getHasList(Long corpId, Long roleId, Long[] resourceIds) {
        String hql = "from RoleRes where corpId=? and roleId=? and isValid=? and resourceId in(:resourceIds) ";
        List list = getList(hql, corpId, roleId, resourceIds);
        return list;
    }

    /*@Override
    public List<RoleRes> getDeleteList(Long corpId, Long roleId, Long[] resourceIds) {
        String hql = "from RoleRes where corpId=? and roleId=? and isValid=? and resourceId not in(:resourceIds) ";
        List list = getList(hql,corpId,roleId,resourceIds);
        return list;
    }*/

    private List<RoleRes> getList(String hql,Long corpId, Long roleId,Long[] resourceIds) {
        List list = this.getSession().createQuery(hql)
                .setParameter(0, corpId)
                .setParameter(1, roleId)
                .setParameter(2, true)
                .setParameterList("resourceIds", resourceIds).list();
        return list;
    }


    @Override
    public void delete(Long corpId, Long roleId, Long[] resourceIds) {
        String hql = "update RoleRes set isValid=? where corpId=? and roleId=? and isValid=? and resourceId not in(:resourceIds) ";
        this.getSession().createQuery(hql)
                .setParameter(0, false)
                .setParameter(1, corpId)
                .setParameter(2, roleId)
                .setParameter(3, true)
                .setParameterList("resourceIds", resourceIds)
                .executeUpdate();
    }

    @Override
    public RoleRes getEntity(Long corpId, Long roleId, Long resourceId) {
        Map map = new HashMap<>();
        map.put("corpId",corpId);
        map.put("roleId",roleId);
        map.put("resourceId",resourceId);
        return this.getEquals(map);
    }

    @Override
    public List<RoleRes> getListByCorpAndRole(Long corpId, Long roleId) {
        Map map = new HashMap<>();
        map.put("corpId",corpId);
        map.put("roleId",roleId);
        map.put("isValid",true);
        return this.getListEquals(map);
    }

}

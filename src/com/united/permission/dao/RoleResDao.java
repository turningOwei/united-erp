package com.united.permission.dao;

import com.united.common.dao.BaseDao;
import com.united.permission.dao.entity.RoleRes;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/16.
 */
public interface RoleResDao extends BaseDao<RoleRes,Long> {
    public void deleteByCorpAndRole(Long corpId, Long roleId);

    public List<RoleRes> getHasList(Long corpId, Long roleId, Long[] resourceIds);

    /*List<RoleRes> getDeleteList(Long corpId, Long roleId, Long[] resourceIds);*/

    void delete(Long corpId, Long roleId, Long[] resourceIds);

    RoleRes getEntity(Long corpId, Long roleId, Long resourceId);

    List<RoleRes> getListByCorpAndRole(Long corpId, Long roleId);
}

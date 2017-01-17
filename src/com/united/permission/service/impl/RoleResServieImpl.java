package com.united.permission.service.impl;

import com.common.CollectionUtil;
import com.united.permission.dao.RoleResDao;
import com.united.permission.dao.SysRoleResDao;
import com.united.permission.dao.entity.RoleRes;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.RoleResServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by turningOwei on 2017/1/16.
 */
@Service
public class RoleResServieImpl implements RoleResServie {
    @Autowired
    private RoleResDao roleResDao;

    @Autowired
    private SysRoleResDao sysRoleResDao;

    @Override
    public List<SysResource> getSysResouceByCorpAndRole(Long corpId, Long roleId) {
        List<SysResource> list = new ArrayList<SysResource>();
        List<Long> roleResIds = new ArrayList<Long>();
        /**
         * 查询系统配置角色资源(固有)
         */
        List<SysRoleRes> sysRoleResList = sysRoleResDao.getListByRole(roleId);
        /**
         * 查询本公司角色资源(一般角色 个性化；超级角色固有)
         */
        List<RoleRes> roleResList = roleResDao.getListByCorpAndRole(corpId,roleId);
        if(CollectionUtil.isNotEmpty(roleResList)){
            for (RoleRes roleRes : roleResList) {
                if(roleRes.getSysResource()!=null)
                    roleResIds.add(roleRes.getSysResource().getOid());
            }
        }
        if(CollectionUtil.isNotEmpty(sysRoleResList)){
            list = getResource(list,sysRoleResList,roleResIds);
        }
        return list;
    }

    private List<SysResource> getResource(List<SysResource> list,List<SysRoleRes> sysRoleResList,List<Long> roleResIds){
        for (SysRoleRes sysRoleRes : sysRoleResList) {
            if(sysRoleRes.getSysResource()!=null){
                SysResource sysResource = sysRoleRes.getSysResource();
                if(roleResIds.contains(sysRoleRes.getSysResource().getOid())){
                    /**
                     * 如果公司角色资源包含系统角色资源,则选中
                     */
                    sysResource.setCheckFlag(true);
                }else{
                    sysResource.setCheckFlag(false);
                }
                list.add(sysResource);
            }
        }
        return list;
    }


    @Override
    public void saveRoleResource(Long corpId, Long roleId, Long[] resourceIds) {
        Assert.notNull(corpId, "公司ID不能为空");
        Assert.notNull(roleId, "权限ID不能为空");
        if(corpId!=null&&roleId!=null){
            if(resourceIds==null||resourceIds.length==0){
                roleResDao.deleteByCorpAndRole(corpId,roleId);
            }else{
                List<RoleRes> hasList = roleResDao.getHasList(corpId,roleId, resourceIds);

                //List<RoleRes> deleteList = roleResDao.getDeleteList(corpId,roleId, resourceIds);

                List<Long> addLongList = getAddLongList(hasList,resourceIds);

                roleResDao.delete(corpId,roleId,resourceIds);

                saveAddResource(corpId,roleId,addLongList);
            }
        }
    }



    private List<Long> getAddLongList(List<RoleRes> hasList, Long[] resourceIds) {
        List<Long> addLongList = CollectionUtil.toArrayList(resourceIds);

        if(hasList!=null&&hasList.size()>0){
            hasList.forEach(T -> {
                if (addLongList.contains(T.getResourceId())) {
                    addLongList.remove(T.getResourceId());
                }
            });
        }
        return addLongList;
    }

    private  List<RoleRes> saveAddResource(Long corpId,Long roleId,  List<Long> addLongList) {
        List<RoleRes> addList = new ArrayList<RoleRes>();
        if(addLongList!=null&&addLongList.size()>0){
            for (Long resourceId : addLongList) {
                if(resourceId!=null){
                    RoleRes entity = roleResDao.getEntity(corpId, roleId, resourceId);
                    entity = entity == null? new RoleRes():entity;

                    entity.setCorpId(corpId);
                    entity.setRoleId(roleId);
                    entity.setResourceId(resourceId);
                    entity.setIsValid(true);
                    roleResDao.save(entity);
                    addList.add(entity);
                }
            }
        }
        return addList;
    }
}

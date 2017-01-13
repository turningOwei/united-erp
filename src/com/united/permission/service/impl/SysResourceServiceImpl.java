package com.united.permission.service.impl;

import com.united.account.dao.entity.Account;
import com.united.permission.dao.SysResourceDao;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.SysResourceService;
import com.united.permission.service.SysRoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    private SysResourceDao sysResourceDao;
    @Autowired
    private SysRoleResService sysRoleResService;

    public SysResource getRootNode(Account account){
        SysResource root = sysResourceDao.getRootSysource();

        //List<SysRoleRes> list = sysRoleResService.getListByRole(account.getAccountRole().getDeptRoleId());

        //List<SysResource> list = sysResourceDao.list();
        List<SysResource> list = this.getListByAccount(account);
        if(list!=null&&list.size() > 0){
            root = fillChildren(list,root);
        }
        return root;
    }



    private SysResource  fillChildren(List<SysResource> list,SysResource node){
        List<SysResource> children = new ArrayList<>();
        for (SysResource sysResource : list) {
            if(node.getOid().equals(sysResource.getParentId())){
                sysResource = fillChildren(list,sysResource);
                children.add(sysResource);
            }
        }
        node.setChildren(children);
        return node;
    }


    @Override
    public List<SysResource> getListByAccount(Account account) {
        return getListByRoleId(account.getDeptRoleId());
    }

    private List<SysResource> getListByRoleId(Long roleId){
        List<SysResource> list = new ArrayList<SysResource>();

        if(roleId==null)
            return list;

        List<SysRoleRes> sysRoleResList = sysRoleResService.getListByRole(roleId);
        if(sysRoleResList!=null&&sysRoleResList.size()>0){
            for (SysRoleRes sysRoleRes : sysRoleResList) {
                list.add(sysRoleRes.getSysResource());
            }
        }
        return list;
    }

    @Override
    public List<SysResource> getAll() {
        return sysResourceDao.getAll();
    }



    @Override
    public List<SysResource> listRoleResource(Long roleId) {
        //select sr.*,srr.oid as flag from sys_resource sr left join (select * from sys_role_res where role_id=2) srr on sr.oid=srr.resource_id
        //StringBuffer hql = new StringBuffer("from SysResource  sr left join (select * from SysRoleRes where roleId=2)srr on sr.oid=srr.resourceId ");
        List<SysResource> allList = sysResourceDao.getAll();
        List<SysRoleRes> roleList = sysRoleResService.getListByRole(roleId);
        if(allList!=null&&allList.size()>0){
            for (SysResource sysResource : allList) {
                if(roleList!=null&&roleList.size()>0){
                    for (SysRoleRes sysRoleRes : roleList) {
                        if(sysRoleRes.getResourceId().equals(sysResource.getOid())){
                            sysResource.setCheckFlag(true);
                        }
                    }
                }
            }
        }
        return allList;
    }

}

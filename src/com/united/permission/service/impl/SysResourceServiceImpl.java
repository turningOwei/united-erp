package com.united.permission.service.impl;

import com.united.permission.dao.SysResourceMapper;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/8.
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    private SysResourceMapper sysResourceMapper;

    public SysResource getRootNode(){
        SysResource root = sysResourceMapper.selectRoot();
        List<SysResource> list = sysResourceMapper.selectAll();
        if(list!=null&&list.size() > 0){
            root = fillChildren(list,root);
        }
        return root;
    }

    private SysResource  fillChildren(List<SysResource> list,SysResource node){
        List<SysResource> children = new ArrayList<>();
        for (SysResource sysResource : list) {
            if(node.getDbId().equals(sysResource.getParentId())){
                sysResource = fillChildren(list,sysResource);
                children.add(sysResource);
            }
        }
        node.setChildren(children);
        return node;
    }

}

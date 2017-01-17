package com.united.permission.service.impl;

import com.common.CollectionUtil;
import com.united.permission.dao.SysRoleResDao;
import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.SysRoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@Service
public class SysRoleResServiceImpl implements SysRoleResService {
    @Autowired
    protected SysRoleResDao sysRoleResDao;
    @Override
    public List<SysRoleRes> getListByRole(Long roleId) {
        return sysRoleResDao.getListByRole(roleId);
    }

    @Override
    public void saveRoleResource(Long roleId, Long[] resourceIds) {
        if(resourceIds==null||resourceIds.length==0){
            sysRoleResDao.deleteByRoleId(roleId);
        }else{
            List<SysRoleRes> hasList = sysRoleResDao.getHasList(roleId, resourceIds);

            //List<SysRoleRes> deleteList = sysRoleResDao.getDeleteList(roleId, resourceIds);

            List<Long> addLongList = getAddLongList(hasList,resourceIds);

            //sysRoleResDao.delete(deleteList);
            sysRoleResDao.delete(roleId, resourceIds);
            saveAddResource(roleId,addLongList );
        }

    }

    private List<SysRoleRes> saveAddResource(Long roleId, List<Long> addLongList ){
        List<SysRoleRes> addList = new ArrayList<SysRoleRes>();
        if(addLongList!=null&&addLongList.size()>0){
            for (Long resourceId : addLongList) {
                if(resourceId!=null){
                    SysRoleRes entity = sysRoleResDao.getEntity(roleId, resourceId);
                    entity = entity ==null? new SysRoleRes():entity;
                    entity.setRoleId(roleId);
                    entity.setResourceId(resourceId);
                    entity.setIsValid(true);
                    sysRoleResDao.save(entity);
                    addList.add(entity);
                }
            }
        }
        return addList;
    }


    private  List<Long> getAddLongList(List<SysRoleRes> hasList,Long[] resourceIds){
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

}

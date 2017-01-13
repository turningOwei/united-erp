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
        return sysRoleResDao.getList("roleId",roleId);
    }

    @Override
    public void saveRoleResource(Long roleId, Long[] resourceIds) {

        List<SysRoleRes> hasList = sysRoleResDao.getHasList(roleId, resourceIds);

        List<SysRoleRes> deleteList = sysRoleResDao.getDeleteList(roleId, resourceIds);

        List<Long> addLongList = getAddLongList(hasList,resourceIds);


        sysRoleResDao.delete(deleteList);
        saveAddResource(roleId,resourceIds,addLongList );
    }

    private List<SysRoleRes> saveAddResource(Long roleId, Long[] resourceIds,List<Long> addLongList ){
        List<SysRoleRes> addList = new ArrayList<SysRoleRes>();
        if(addLongList!=null&&addLongList.size()>0){
            for (Long resourceId : addLongList) {
                if(resourceId!=null){
                    SysRoleRes entity = new SysRoleRes();
                    entity.setRoleId(roleId);
                    entity.setResourceId(resourceId);
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

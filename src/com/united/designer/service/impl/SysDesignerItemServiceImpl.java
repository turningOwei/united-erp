package com.united.designer.service.impl;

import com.common.CollectionUtil;
import com.united.designer.dao.SysDesignerItemDao;
import com.united.designer.dao.entity.SysDesignerItem;
import com.united.designer.service.SysDesignerItemService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 002465 on 2017/12/7.
 */
@Service
public class SysDesignerItemServiceImpl implements SysDesignerItemService {
    @Autowired
    private SysDesignerItemDao sysDesignerItemDao;

    @Override
    public List<SysDesignerItem> getAll(){
        return sysDesignerItemDao.getAll();
    }

    @Override
    public void saveOrUpdate(SysDesignerItem entity){
        sysDesignerItemDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(List<SysDesignerItem> list){
        if(CollectionUtils.isNotEmpty(list)){
            for (SysDesignerItem sysDesignerItem : list) {
                sysDesignerItemDao.saveOrUpdate(sysDesignerItem);
            }
        }
    }
}

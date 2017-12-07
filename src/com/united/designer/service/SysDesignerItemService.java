package com.united.designer.service;

import com.united.designer.dao.entity.SysDesignerItem;

import java.util.List;

/**
 * Created by 002465 on 2017/12/7.
 */
public interface SysDesignerItemService {
    public List<SysDesignerItem> getAll();

    public void saveOrUpdate(SysDesignerItem entity);

    public void saveOrUpdate(List<SysDesignerItem> list);
}

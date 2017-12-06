package com.united.corp.service.impl;

import com.united.corp.dao.CorpDeptDao;
import com.united.corp.dao.entity.CorpDept;
import com.united.corp.service.CorpDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by turningOwei on 2016/12/30.
 */
@Service
public class CorpDeptServiceImpl implements CorpDeptService {
    @Autowired
    private CorpDeptDao corpDeptDao;
    @Override
    public List<CorpDept> list(Long corpId) {
        return  corpDeptDao.getList("corp_id",corpId);
    }

}

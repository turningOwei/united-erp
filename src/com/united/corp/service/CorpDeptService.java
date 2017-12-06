package com.united.corp.service;

import com.united.corp.dao.entity.CorpDept;

import java.util.List;

/**
 * Created by turningOwei on 2016/12/30.
 */
public interface CorpDeptService {
    List<CorpDept> list(Long corpId);
}


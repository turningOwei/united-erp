package com.united.corp.service;

import com.united.corp.dao.entity.Company;

/**
 * Created by turningOwei on 2017/1/11.
 */
public interface CompanyService {
    public Company getByCorpCode(String corpCode);
}

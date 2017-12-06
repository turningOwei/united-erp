package com.united.corp.service.impl;

import com.united.corp.dao.CompanyDao;
import com.united.corp.dao.entity.Company;
import com.united.corp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by turningOwei on 2017/1/11.
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public Company getByCorpCode(String corpCode) {
        return companyDao.get("corpCode",corpCode);
    }
}

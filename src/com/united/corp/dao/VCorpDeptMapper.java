package com.united.corp.dao;

import com.united.corp.dao.entity.VCorpDept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VCorpDeptMapper {
    List<VCorpDept> listViewByCorpId(Long corpId);
}
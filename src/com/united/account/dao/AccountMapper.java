package com.united.account.dao;

import com.united.account.dao.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectAllByCorp(Integer corpId);

    Integer selectAllByCorpCount(Integer corpId);
}
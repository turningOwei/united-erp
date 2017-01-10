package com.united.account.dao.impl;

import com.united.account.dao.AccountDao;
import com.united.account.dao.entity.Account;
import com.united.common.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by turningOwei on 2017/1/6.
 */
@Repository
public class AccountDaoImpl extends BaseDaoImpl<Account, Long> implements AccountDao {

}

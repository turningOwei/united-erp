package sys;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.management.counter.AbstractCounter;


/**
 * Created by turningOwei on 2017/1/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class AccountTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void test(){
        Account account = accountService.getByOId(1l);
        //account.getAccountRole().getOid();
       /* System.out.println(account.getSysDeptRole().getName());
        System.out.println(account.getName());*/
       //List<Account> list = accountService.listByPage(account);
       //Integer totalCount =  accountService.listByPageCount(account);
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).serializeNulls()
                .create();
        //System.out.println(gson.toJson(list));
        Boolean valid = accountService.validDeptSuperAdminExist(account);
        System.out.println(valid);
    }

    @Test
    public void testInsert(){
        Account account = new Account();
        account.setCorpId(11l);
        accountService.saveOrUpdateAccount(account);
    }
}

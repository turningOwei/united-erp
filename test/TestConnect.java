import com.united.account.dao.AccountDao;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by turningOwei on 2017/1/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class TestConnect {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(TestConnect.class);
    @Resource
    AccountDao accountDao;
    @Resource
    private AccountService accountService;
    @Test
    public void test(){
        Account entity = accountService.getByOId(1l);

        System.out.println(entity.getName());
    }
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.AccountMapper;
import com.united.account.dao.entity.Account;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class AccountTest {
    //AccountMapper

    private static Logger log = org.slf4j.LoggerFactory.getLogger(AccountTest.class);
    @Resource
    private AccountMapper accountMapper;
    @Test
    public void test(){
        //List<Account> list = accountMapper.selectAllByCorp(1);
        Account list = accountMapper.selectByPrimaryKey(1l);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String str = gson.toJson(list);
        log.info(str);
    }
}

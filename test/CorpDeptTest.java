import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.AccountMapper;
import com.united.account.dao.entity.Account;
import com.united.corp.dao.entity.CorpDept;
import com.united.corp.service.CorpDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by turningOwei on 2016/12/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class CorpDeptTest {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(CorpDeptTest.class);

    @Resource
    private CorpDeptService corpDeptService;
    @Test
    public void test(){
        List<CorpDept> lists = corpDeptService.list(1l);
        System.out.println(lists.size());
    }
}

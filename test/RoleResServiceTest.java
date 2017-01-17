import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.account.dao.entity.Account;
import com.united.account.service.AccountService;
import com.united.permission.service.RoleResServie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by turningOwei on 2017/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class RoleResServiceTest {
    @Autowired
    private RoleResServie roleResServie;
    @Test
    public void test(){
        roleResServie.saveRoleResource(1l,1l,null);
    }
}

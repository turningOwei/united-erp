import com.united.permission.dao.SysUserMapper;
import com.united.permission.dao.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by turningOwei on 2016/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //继承SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class UserTest {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(UserTest.class);
    @Resource
    private SysUserMapper sysUserMapper;
    @Test
    public void insert(){
        SysUser user = new SysUser();
        user.setUserName("test");
        sysUserMapper.insert(user);
    }


}

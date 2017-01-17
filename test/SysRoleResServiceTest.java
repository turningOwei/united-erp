import com.united.permission.dao.entity.SysRoleRes;
import com.united.permission.service.SysRoleResService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysRoleResServiceTest {
    @Autowired
    private SysRoleResService sysRoleResService;

    @Test
    public void test(){
       /* List<SysRoleRes> list = sysRoleResService.getListByRole(1l);

        System.out.println(list.size());*/
        Long[] ids =new Long[1];
        ids[0] =1l;
        sysRoleResService.saveRoleResource(1l,ids);
    }
}

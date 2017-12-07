package sys;

import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.service.SysDeptRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysDeptRoleServiceTest {
    @Autowired
    private SysDeptRoleService sysDeptRoleService;

    @Test
    public void test(){
        List<SysDeptRole> list = sysDeptRoleService.getAll();
        System.out.println(list.size());
    }
}

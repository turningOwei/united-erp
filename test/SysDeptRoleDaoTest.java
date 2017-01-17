import com.united.permission.dao.SysDeptRoleDao;
import com.united.permission.dao.entity.SysDeptRole;
import com.united.permission.service.SysDeptRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by turningOwei on 2017/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysDeptRoleDaoTest {
    @Autowired
    private SysDeptRoleService sysDeptRoleService;

    @Test
    public void test(){
        List<SysDeptRole> list = sysDeptRoleService.listNotGeneralMager(1l);
        System.out.println(list.get(0).getSysRoleRes());
    }


    @Test
    public void test1(){
        SysDeptRole entity = sysDeptRoleService.getDeptSuperAdmin(1l);
        System.out.println(entity.getName());
    }
}

package sys;

import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
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
public class SysResourceTest {
    @Autowired
    private SysResourceService sysResourceService;

    @Test
    public void test(){
        /*SysResource res = sysResourceService.getRootNode(null);
        System.out.println(res.getText());*/

        List<SysResource> list = sysResourceService.listRoleResource(1l);
        System.out.println(list.size());
    }
}

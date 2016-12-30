import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.united.permission.dao.entity.SysResource;
import com.united.permission.service.SysResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by turningOwei on 2016/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring.xml"})
public class SysResourceTest {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(SysResourceTest.class);
    @Resource
    private SysResourceService sysResourceService;
    @Test
    public void test(){
        SysResource rootNode = sysResourceService.getRootNode();
        Gson gson = new GsonBuilder().serializeNulls().create();
        String str = gson.toJson(rootNode);
        log.info(str);
    }
}

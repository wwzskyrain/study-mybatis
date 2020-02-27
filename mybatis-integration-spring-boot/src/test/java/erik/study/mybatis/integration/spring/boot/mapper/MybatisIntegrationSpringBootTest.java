package erik.study.mybatis.integration.spring.boot.mapper;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.integration.spring.boot.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-27 16:03
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class MybatisIntegrationSpringBootTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisIntegrationSpringBootTest.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test_select_annotation_with_save_column_as_another_name() {
        Long userId = 1001L;
        SysUser sysUser = sysUserMapper.selectById(userId);

        logger.info("found sysUser={}", sysUser);
        Assert.assertEquals(sysUser.getId(), userId);
    }

    @Test
    public void test_select_annotation_with_results() {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
        Assert.assertTrue(sysUsers.size() > 0);
    }


}

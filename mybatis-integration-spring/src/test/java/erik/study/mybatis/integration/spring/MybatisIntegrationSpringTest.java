package erik.study.mybatis.integration.spring;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.integration.spring.entity.SysUser;
import erik.study.mybatis.integration.spring.mapper.SysUserMapper;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author erik.wang
 * @date 2020-02-27 09:13
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-config.xml"})
public class MybatisIntegrationSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisIntegrationSpringTest.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @org.junit.Test
    public void test_select_annotation_with_save_column_as_another_name() {
        Long userId = 1001L;
        SysUser sysUser = sysUserMapper.selectById(userId);

        logger.info("found sysUser={}", sysUser);
        Assert.assertEquals(sysUser.getId(), userId);
    }

    @org.junit.Test
    public void test_select_annotation_with_results() {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
        Assert.assertTrue(sysUsers.size() > 0);
    }

}

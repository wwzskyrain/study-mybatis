package erik.study.mybatis.base.use.annotation.config.mapper;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.base.use.annotation.config.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-26 21:22
 * @description
 */
public class SysUserMapperTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SysUserMapperTest.class);

    @Test
    public void test_select_annotation_with_save_column_as_another_name() {
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            Long userId = 1001L;
            SysUser sysUser = sysUserMapper.selectById(userId);
            Assert.assertEquals(sysUser.getId(), userId);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test_select_annotation_with_results() {
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = sysUserMapper.selectAll();
            logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
            Assert.assertTrue(sysUsers.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test_select_annotation_with_result_map_specify_by_id() {
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = sysUserMapper.selectByName("erik-test");
            logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
            Assert.assertTrue(sysUsers.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test() {
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = sysUserMapper.selectByPassword("123456");
            logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
            Assert.assertTrue(sysUsers.size() > 0);
        } finally {
            sqlSession.close();
        }
    }


}

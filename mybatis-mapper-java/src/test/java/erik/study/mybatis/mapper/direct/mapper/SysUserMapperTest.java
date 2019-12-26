package erik.study.mybatis.mapper.direct.mapper;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.mapper.common.mapper.SysUserMapper;
import erik.study.mybatis.mapper.common.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author erik.wang
 * @Date 2019-12-22
 */
public class SysUserMapperTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(SysUserMapperTest.class);

    @Test
    public void test_select_by_id() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            Long id = 1001L;
            SysUser sysUser = sysUserMapper.selectUserById(id);
            Assert.assertNotNull(sysUser);
            logger.info("sysUser" + JSON.toJSONString(sysUser));
        } catch (Exception e) {
            logger.info("exception:", e);
            sqlSession.close();
        }
    }

}

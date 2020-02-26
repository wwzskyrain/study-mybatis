package erik.study.mybatis.base.use.xml.config.mapper;

import erik.study.mybatis.base.use.xml.config.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author erik.wang
 * @date 2020-02-26 21:22
 * @description
 */
public class SysUserMapperTest extends TestBase {


    @Test
    public void test_select_by_id_with_result_map() {
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            Long userId = 1001L;
            SysUser sysUser = sysUserMapper.selectById(userId);
            Assert.assertEquals(sysUser.getId(), userId);
        } finally {
            sqlSession.close();
        }
    }

}

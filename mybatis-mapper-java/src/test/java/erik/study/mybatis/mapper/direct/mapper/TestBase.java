package erik.study.mybatis.mapper.direct.mapper;

import erik.study.mybatis.mapper.common.config.MybatisConfig;
import erik.study.mybatis.mapper.common.mapper.CountryMapper;
import erik.study.mybatis.mapper.common.mapper.SysUserMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

/**
 * @author erik.wang
 * @Date 2019-12-22
 */
public class TestBase {

    protected SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        Configuration configuration = MybatisConfig.getSqlSessionFactoryConfiguration();
        configuration.addMapper(CountryMapper.class);
        configuration.addMapper(SysUserMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }
}

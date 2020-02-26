package erik.study.mybatis.mapper.generator.mapper;

import erik.study.mybatis.mapper.generator.dao.CountryMapper;
import erik.study.mybatis.mapper.generator.domain.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author erik.wang
 * @date 2020-02-11 22:36
 * @description
 */
public class SysUserMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(CountryDaoTest.class);

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void test_country_example_that_insert_and_query() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);

            SysUser sysUser = new SysUser();

        } catch (Exception e) {
            logger.info("exception occur", e);
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}

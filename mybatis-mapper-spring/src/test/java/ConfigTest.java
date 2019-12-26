
import erik.study.mybatis.mapper.common.model.Country;
import erik.study.mybatis.mapper.spring.mapper.CountryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.Reader;

/**
 * @author erik.wang
 * @Date 2019-12-23
 */
public class ConfigTest {

    private static final Logger logger = LoggerFactory.getLogger(ConfigTest.class);

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
    public void get() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country country = countryMapper.selectOneByIdAndCode(2, "US");
            logger.info("country" + country);
        } catch (Exception e) {
            logger.error("exception:{}",e);
            sqlSession.close();
            Assert.fail();
        }
    }

}

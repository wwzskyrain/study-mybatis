package erik.study.mybatis.mapper.direct.mapper;

import erik.study.mybatis.mapper.common.mapper.CountryMapper;
import erik.study.mybatis.mapper.common.model.Country;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author erik.wang
 * @Date 2019-12-22
 */
public class CountryMapperTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(CountryMapperTest.class);

    @Test
    public void testSelectOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country country = countryMapper.selectOneByIdAndCode(2, "US");
            logger.info("country" + country);
        } catch (Exception e) {
            logger.info("exception:", e);
            sqlSession.close();
            Assert.fail();
        }
    }

}

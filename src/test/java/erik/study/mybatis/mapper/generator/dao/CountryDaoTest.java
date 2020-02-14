package erik.study.mybatis.mapper.generator.dao;

import erik.study.mybatis.mapper.generator.domain.Country;
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
 * @Date 2019-12-26
 */
public class CountryDaoTest {

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
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

            Country countryRecord = new Country();
            countryRecord.setCountryCode("JP");
            countryRecord.setCountryName("日本");
            countryMapper.insert(countryRecord);
//          insert的返回值是成功插入的数据条数；对象的id属性会被赋值，值就是表的主键的自增值。
            Country foundCountry = countryMapper.selectByPrimaryKey(countryRecord.getId());
            Assert.assertNotNull(foundCountry);
            Assert.assertEquals(foundCountry.getId(), countryRecord.getId());
            Assert.assertEquals(foundCountry.getCountryCode(), countryRecord.getCountryCode());

        } catch (Exception e) {
            logger.info("exception occur", e);
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void test_country_example_insert_selective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

            Country countryRecord = new Country();
            countryRecord.setCountryCode("JP");
            countryMapper.insertSelective(countryRecord);

            Country foundCountry = countryMapper.selectByPrimaryKey(countryRecord.getId());
            Assert.assertNotNull(foundCountry);
            Assert.assertEquals(foundCountry.getId(), countryRecord.getId());
            Assert.assertEquals(foundCountry.getCountryCode(), countryRecord.getCountryCode());

        } catch (Exception e) {
            logger.error("exception occurs, ", e);
        }
    }

    @Test
    public void test_country_example_query() {
//  用生成的代码，来完成update，我就不测了。看方法名就很好懂
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

            countryMapper.updateByExample(null, null);
            countryMapper.updateByExampleSelective(null, null);

            countryMapper.updateByPrimaryKey(null);
            countryMapper.updateByPrimaryKeySelective(null);
        } catch (Exception e) {
            logger.error("exception occurs, ", e);
        }
    }

}

package erik.study.mybatis.base.use.xml.config.mapper;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.base.use.xml.config.entity.Country;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-26 20:40
 * @description
 */
public class CountryMapperTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(CountryMapperTest.class);

    @Test
    public void test_select_all() {
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            List<Country> countries = countryMapper.selectAll();

            logger.info("found country:{}", JSON.toJSONString(countries));
            Assert.assertTrue(countries.size() > 0);
        } catch (Exception e) {
            logger.info("exception occur", e);
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void test_select_by_id() {
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country country = countryMapper.selectById(1L);
            logger.info("found country:{}", JSON.toJSONString(country));
            Assert.assertTrue(country.getId().equals(1L));
        } catch (Exception e) {
            logger.info("exception occur", e);
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}

import erik.study.mybatis.mapper.common.model.Country;
import erik.study.mybatis.mapper.spring.mapper.CountryMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author erik.wang
 * @Date 2020-01-06
 */
public class CountryMapperTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    public void test_query_by_id() {
        doTest(new TestCallBack() {
            @Override
            public void doTest(SqlSession sqlSession) {
                CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
                Country foundCountry = countryMapper.selectOneById(2);
                Assert.assertNotNull(foundCountry);
            }
        });
    }

    @Test
    public void test_update_by_id() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Integer countryId = 2;
            Country country = countryMapper.selectOneById(countryId);

            country.setCountryName("updated_" + country.getCountryName());
            countryMapper.updateById(country);

            Country foundCountry = countryMapper.selectOneById(countryId);

            Assert.assertNotNull(foundCountry);
            Assert.assertEquals(foundCountry.getCountryName(), country.getCountryName());

        } catch (Exception e) {
            logger.error("exception:{}", e);
            Assert.fail();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


    @Test
    public void test_first_level_cache() {
        doTest(new TestCallBack() {
            @Override
            public void doTest(SqlSession sqlSession) {
                CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
                Integer countryId = 2;
                Country firstFoundCountry = countryMapper.selectOneById(countryId);

                String updatedCountryName = "updatedCountryName";
                firstFoundCountry.setCountryName(updatedCountryName);

                logger.info("second selectOneById with countryId:{}", countryId);
                Country secondFoundCountry = countryMapper.selectOneById(countryId);
                //  第二次调用selectOneById，由于参数还是2，所以这次调用没有真正去请求，而是走了一级缓存
                Assert.assertEquals(firstFoundCountry, secondFoundCountry);
                Assert.assertEquals(firstFoundCountry.getCountryName(), secondFoundCountry.getCountryName());

                Country thirdFoundCountry = countryMapper.selectOneById(3);
                Assert.assertNotNull(thirdFoundCountry);
            }
        });
    }

    @Test
    public void test_first_level_cache_flush() {
        doTest(sqlSession -> {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country firstCountry = countryMapper.selectOneById(2);

            Country countryToUpdate = countryMapper.selectOneById(3);
            countryToUpdate.setCountryName("updated");
            countryMapper.updateById(countryToUpdate);

            Country secondCountry = countryMapper.selectOneById(2);
            Assert.assertNotNull(firstCountry);
            Assert.assertNotEquals(firstCountry, secondCountry);
            logger.info("firstCountry hasCode:{}, secondCountry hashCode:{}",
                    firstCountry.hashCode(), secondCountry.hashCode());
        });
    }


}

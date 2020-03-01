package erik.study.mybatis.common.mapper.generator.mapper;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.common.mapper.generator.domain.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author erik.wang
 * @date 2020-02-26 16:17
 * @description
 */
public class CommonMapperUsageWithJavaTest {

    private static final Logger logger = LoggerFactory.getLogger(CommonMapperUsageWithJavaTest.class);

    
    SqlSession sqlSession;

    @Before
    public void init() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            //创建一个MapperHelper
            MapperHelper mapperHelper = new MapperHelper();
//特殊配置
            Config config = new Config();
//主键自增回写方法,默认值MYSQL,详细说明请看文档
            config.setIDENTITY("MYSQL");
//支持getter和setter方法上的注解
            config.setEnableMethodAnnotation(true);
//设置 insert 和 update 中，是否判断字符串类型!=''
            config.setNotEmpty(true);
//校验Example中的类型和最终调用时Mapper的泛型是否一致
            config.setCheckExampleEntityClass(true);
//启用简单类型
            config.setUseSimpleType(true);
//枚举按简单类型处理
            config.setEnumAsSimpleType(true);
//自动处理关键字 - mysql
            config.setWrapKeyword("`{0}`");
//设置配置
            mapperHelper.setConfig(config);
//注册通用接口，和其他集成方式中的 mappers 参数作用相同
//4.0 之后的版本，如果类似 Mapper.class 这样的基础接口带有 @RegisterMapper 注解，就不必在这里注册
//            mapperHelper.registerMapper(Mapper.class);
//配置 mapperHelper 后，执行下面的操作
            mapperHelper.processConfiguration(sqlSession.getConfiguration());

        } catch (IOException ignore) {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ignore.printStackTrace();
        }
    }

    // 这种用法将会导致失败，因为'通用mapper'没有被嵌入进来
    @Test
    public void test_country_example_that_insert_and_query() {

        try {
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Example example = new Example(Country.class);
            example.createCriteria()
                    .andEqualTo("countryCode", "CN");

            List<Country> countries = countryMapper.selectByExample(example);
            logger.info("found countries:{}", JSON.toJSONString(countries));
            Assert.assertTrue(countries.size() == 1);

        } catch (Exception e) {
            logger.info("exception occur", e);
            sqlSession.rollback();
            sqlSession.close();
            Assert.fail();
        }
    }

}

package erik.study.mybatis.mapper.spring.mapper;

<<<<<<< HEAD:src/test/java/erik/study/mybatis/mapper/generator/mapper/SysUserMapperTest.java
import erik.study.mybatis.mapper.generator.dao.CountryMapper;
import erik.study.mybatis.mapper.generator.domain.SysUser;
=======
import erik.study.mybatis.mapper.common.model.Country;
import erik.study.mybatis.mapper.spring.mapper.CountryMapper;
>>>>>>> ebf03bb6fa56a84efaa36e7f9033bb10bc533dc1:mybatis-mapper-spring/src/test/erik.study.mybatis.mapper.spring.mapper/TestBase.java
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
 * @Date 2019-12-23
 */
public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

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


    public void doTest(TestCallBack callBack) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            callBack.doTest(sqlSession);
        } catch (Exception e) {
            logger.error("exception:{}", e);
            sqlSession.close();
            Assert.fail();
        }
    }

}

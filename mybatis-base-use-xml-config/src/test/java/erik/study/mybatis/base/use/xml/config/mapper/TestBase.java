package erik.study.mybatis.base.use.xml.config.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.Reader;

/**
 * @author erik.wang
 * @date 2020-02-26 21:22
 * @description
 */
public class TestBase {


    public SqlSession sqlSession;

    @Before
    public void init() {
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }
}

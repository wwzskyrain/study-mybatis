package erik.study.mybatis.mapper.spring.mapper;

import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author erik.wang
 * @Date 2020-01-06
 */
public interface TestCallBack {

    void doTest(SqlSession sqlSession);

}

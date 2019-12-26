package erik.study.mybatis.mapper.common.config;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * @author erik.wang
 * @Date 2019-12-22
 */
public class MybatisConfig {

    public static DataSource getDataSource() {
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setDriver("com.mysql.jdbc.Driver");
        unpooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis");
        unpooledDataSource.setUsername("root");
        unpooledDataSource.setPassword("erik");
        return unpooledDataSource;
    }

    public static Configuration getSqlSessionFactoryConfiguration() {
        DataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);

        return configuration;
    }

}

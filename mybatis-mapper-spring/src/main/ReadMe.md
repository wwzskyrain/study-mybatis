# 1.先熟悉啊下mybatis吧
前言：嘘，果然是"真菜"，连mybatis都不会用，搞了快一个小时。

1.  用代码的方式配置mybatis的SQLSessionFactory。
2.  还搞出来mybatis自己实现的UnPooledDatasource。
3.  不想使用xml配置（xml咱也会，demo多呀。），就用注解的形式：在Mapper的方法上用
    @Select这样的注解。
4.  结果映射？开启'驼峰转换配置'，比如`configuration.setMapUnderscoreToCamelCase(true);`
5.  jdbc.driven用高版本
    ```
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.16</version>
        <!-- 升级到8.0.16版本，因为mysql服务器的版本升级到了8.x，其认证方法改成了caching_sha2_password -->
    </dependency>
    ```  
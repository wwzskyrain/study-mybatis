1.  项目主旨：实践mybatis的注解配置用法
2.  注意事项
    1.  jar包依赖上，与xml配置方式一样。——废话
    2.  配置中，mapper配置，只能用package来指明mapper接口的包名了。
    3.  注意select之后的映射
        1.  使用as，被列起别名
        2.  使用 @Results注解
        3.  使用 @Results的id属性 配合 @ResultMap来复用 @Results的内容
    4.  使用方式，只能是接口了，因为压根都没有定义命名空间。
3.  todo
    1.  select注解测试了，以后在测试一下@insert、@update、 @select
    
1.  项目主旨：实践一下mybatis和spring-boot的集成
2.  项目意义
    1.  spring-boot是大大减少了一些常规的bean的配置，也可以简单说spring-boot省去了spring-context的配置文件
    2.  mybatis使用'注解配置方式'来减少mapper.xml的配置
        同时也减少了mybatis的配置（该配置通常是文件mybatis-config.xml）
    3.  所以现在看来，就只需要在spring-boot的属性文件配置jdbc就好了
3.  注意事项：
    1.  Mapper接口是通过spring-boot对@Mapper注解的扫描进去的。
    2.  除了使用@Mapper之外，还可以用@MapperScan(value = {"mapper接口包名1","mapper接口包名2"})
    
4.  成果展示
    1.  和mybatis与spring集成一样，能够用自动注入mapper接口，并用该接口完成db操作，
        就说明集成成功了。
5.  有点和不足：
    1.  集成spring-boot并不一定要搞一个spring-mvc项目，就一个最简单的spring-boot容器就可以了。
        这里我把spring-boot就简单看成了一个bean容器。
    2.  spring-boot的unit
    
    
    
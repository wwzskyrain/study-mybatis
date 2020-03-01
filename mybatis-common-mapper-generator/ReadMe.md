1.  主题:实践通用mapper
2.  通用Mapper有什么好处？
    1.  代码精简
        1.  相比一般的'xml配置'用法，精简了mapper.xml文件，只保留了一个resultMap的定义。
        2.  相比MBG的用法（MBG也是基于xml配置的用法），
            减少了Example的方法和方法对应的mapper.xml（后者也属于1部分的代码精简）；
            却还可以使用Example方式来编程使用
        
        3.  提供了好多通用的接口，几乎不用写sql语句（这一点可看出和Hibernate的价值取向）
3.  注意点
    1.  配置以生成代码：主要是配置generator-config.xml，以生成entity、Mapper.xml接口
        和极简的mapper.xml文件
        注意：
            1.  我们不需要生成Example,所以将 targetRuntime="MyBatis3Simple"，而不是
                targetRuntime="MyBatis3"。
    2.  如何编码使用呢：
        1.  ut中使用了两套编程使用方法，一个是基于java的，一个是基于spring的；官网还有一种是
        基于spring-boot的，这一种咱暂时不实践。[三种使用方式的官网文档](https://github.com/abel533/Mapper/wiki/1.integration)

4.  总结：
    有了通用mapper，我们可以达到的效果
    1.  不用手动写entity、Mapper.接口、mapper.xml文件
    2.  直接使用通用mapper的方法，爽歪歪。
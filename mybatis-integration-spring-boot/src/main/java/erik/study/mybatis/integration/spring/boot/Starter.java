
package erik.study.mybatis.integration.spring.boot;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.integration.spring.boot.entity.SysUser;
import erik.study.mybatis.integration.spring.boot.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Starter implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
        System.out.println("Starter over.");
    }

    @Autowired
    private SysUserMapper sysUserMapper;

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }


    @Override
    public void run(String... args) throws Exception {
        List<SysUser> sysUsers = sysUserMapper.selectAll();
        logger.info("found sysUsers={}", JSON.toJSONString(sysUsers));
    }
}
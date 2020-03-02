
package erik.study.mybatis.integration.spring.boot;

import com.alibaba.fastjson.JSON;
import erik.study.mybatis.integration.spring.boot.entity.SysUser;
import erik.study.mybatis.integration.spring.boot.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
        System.out.println("Starter over.");
    }
}
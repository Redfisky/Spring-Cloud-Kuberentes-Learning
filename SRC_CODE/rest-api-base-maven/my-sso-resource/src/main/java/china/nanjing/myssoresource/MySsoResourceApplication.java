package china.nanjing.myssoresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Resource Server如果配置不当会报错 Invalid Token， 详情见 https://stackoverflow.com/questions/51048179/spring-boot-2-0-3-security-oauth2-autoconfigure
 * 使用Zuul当作Resource Server后就不用在每个真正的资源服务器配置一遍Spring Security Oauth2 ResourceServerConfigurerAdapter 了
 */
@SpringBootApplication
@EnableResourceServer
public class MySsoResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySsoResourceApplication.class, args);
    }

}

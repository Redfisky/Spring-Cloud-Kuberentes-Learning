package china.nanjing.myssoauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class MySsoAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySsoAuthorizationApplication.class, args);
    }

}

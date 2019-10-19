package china.nanjing.mysso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MySsoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySsoClientApplication.class, args);
    }

}

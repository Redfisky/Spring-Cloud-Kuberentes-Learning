package china.nanjing.mykingdom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyKingdomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyKingdomApplication.class, args);
    }

}

package china.nanjing.myzipkin2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;



@SpringBootApplication
@EnableZipkinServer
public class MyZipkin2Application {

    public static void main(String[] args) {
        SpringApplication.run(MyZipkin2Application.class, args);
    }

}

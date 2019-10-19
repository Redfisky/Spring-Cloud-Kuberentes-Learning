package china.nanjing.mychancellor;

import china.nanjing.mychancellor.service.FeignTestService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyChancellorApplicationTests {

    @Autowired
    private FeignTestService feignTestService;

    @Test
    public void contextLoads() {
    }

    @Before
    public void beforeAllTests() {

    }


}

package china.nanjing.mycache;

import china.nanjing.mycache.util.RedisCacheProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyCacheApplicationTests {

    @Autowired
    @Qualifier(value = "redisTemplateOne")
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Before
    public void beforeTests() {

    }

    @Test
    public void redisTempalteTest() {
        BoundValueOperations<Object, Object> boundValueOperations = redisTemplate.boundValueOps("some-key");
        boundValueOperations.set(new StringBuffer("whatever it is"));
        log.info("redisTempalteTest");
        log.info(Objects.requireNonNull(boundValueOperations.get()).toString());
    }

    @Test
    public void redisTempalteTest2() {
        RedisTemplate<Object, Object> redisTemplate = RedisCacheProvider.getRedisTemplate();
        BoundListOperations<Object, Object> boundListOps = redisTemplate.boundListOps("some-key-2");
        boundListOps.leftPush("1");
        boundListOps.leftPush("2");
        boundListOps.leftPush("3");
        log.info("redisTempalteTest2");
        Long size = boundListOps.size();
        for (int i = 0; i < size; i++) {
            log.info(boundListOps.rightPop().toString());
        }
    }

}

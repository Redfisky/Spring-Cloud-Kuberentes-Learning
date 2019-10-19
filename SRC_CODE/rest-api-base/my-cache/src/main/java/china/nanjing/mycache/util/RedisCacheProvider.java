package china.nanjing.mycache.util;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis缓存提供类，供其他模块调用
 *
 * @author Chen Hongyu
 */
public class RedisCacheProvider {

    //由于当前class不在spring boot框架内（不在web项目中）所以无法使用autowired，使用此种方法进行注入
    private static RedisTemplate<Object, Object> redisTemplate = (RedisTemplate<Object, Object>) SpringCacheBeanUtil.getBean("redisTemplateOne");

    private static KeyGenerator keyGenerator = (KeyGenerator) SpringCacheBeanUtil.getBean("keyGenerator");

    public static RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public static void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheProvider.redisTemplate = redisTemplate;
    }

    public static KeyGenerator getKeyGenerator() {
        return keyGenerator;
    }

    public static void setKeyGenerator(KeyGenerator keyGenerator) {
        RedisCacheProvider.keyGenerator = keyGenerator;
    }

    public RedisCacheProvider() {
    }


}

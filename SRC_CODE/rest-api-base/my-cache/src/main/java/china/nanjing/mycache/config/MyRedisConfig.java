package china.nanjing.mycache.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Objects;


/**
 * @author redfisky
 */
@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class MyRedisConfig extends CachingConfigurerSupport {


    /**
     * @param redisConnectionFactory LettuceConnectionFactory
     * @return RedisTemplate<Object, Object>
     */
    @Bean(name = "redisTemplateOne")
    public RedisTemplate<Object, Object> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 切换Redis库DB2
        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        Objects.requireNonNull(jedisConnectionFactory).setDatabase(2);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        jedisConnectionFactory.afterPropertiesSet();
//        jedisConnectionFactory.resetConnection();
        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // key的序列化采用StringRedisSerializer key 必须先设置
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // value值的序列化采用fastJsonRedisSerializer
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        return redisTemplate;

    }

    /**
     * 自定义缓存key的生成策略。默认的生成策略是看不懂的(乱码内容) 通过Spring 的依赖注入特性进行自定义的配置注入并且此类是一个配置类可以更多程度的自定义配置
     *
     * @return KeyGenerator
     */
    @Override
    @Bean(name = "keyGenerator")
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append(o.getClass().getName()).append(" ");
            stringBuffer.append(method.getName());
            for (Object object :
                    objects) {
                stringBuffer.append(object.toString());
            }
            return stringBuffer.toString();
        };
    }

    /**
     * 缓存管理器
     *
     * @param redisConnectionFactory RedisConnectionFactory
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory);
        return builder.build();
    }

}

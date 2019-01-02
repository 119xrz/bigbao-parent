package com.bigbao.graph.redis;

import org.junit.Test;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2018/8/28
 */
public class RedisTest {

    @Test
    public void testA(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("127.0.0.1");
        configuration.setPort(6379);
        configuration.setPassword(RedisPassword.of("123456"));
        configuration.setDatabase(0);
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofMillis(3000));//  connection timeout
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration,jedisClientConfiguration.build());
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        template.opsForValue().set("test","hehe",60, TimeUnit.SECONDS);
        System.out.println(template.opsForValue().get("test"));
    }

    @Test
    public void testB(){
        /*Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        jedis.select(1);
        jedis.set("test","hehe");
        System.out.println(jedis.get("test"));*/
    }
}

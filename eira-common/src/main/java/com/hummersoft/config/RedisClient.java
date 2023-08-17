package com.hummersoft.config;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisClient {

    private RedisTemplate<String, String> redisTemplate;

    public void setKey(String key, String value, Long timeout){
        redisTemplate.opsForValue().set(key,value, Duration.ofSeconds(timeout));
    }

    public String getKey(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteKey(String key){
        redisTemplate.delete(key);
    }
}

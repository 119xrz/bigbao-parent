package com.bigbao.graph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Date 2018/8/24
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<String,Serializable> redisCacheTemplate;

    @GetMapping("/test")
    public String test(){
        if(null != redisTemplate){
            System.out.println("hehe");
            //redisTemplate.opsForValue().set("test","hehe");
            redisCacheTemplate.opsForValue().set("test2","haha",1000);
            String test2 = redisCacheTemplate.opsForValue().get("test2").toString();
            System.out.println(test2);
        }
        return "Hello SB";
    }
}

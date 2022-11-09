package com.mypetlikeit.config.cache;

import java.time.Duration;

import org.apache.ibatis.cache.CacheKey;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableCaching
public class CacheConfig {
    
    // @Bean
    // public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory){
    //     RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
    //             .disableCachingNullValues()
    //             .entryTtl(Duration.ofSeconds(CacheKey.DEFAULT_EXPIRE_SEC))
    //             .computePrefixWith(CacheKeyPrefix.simple())
    //             .serializeKeysWith(
    //                     RedisSerializationContext.SerializationPair
    //                             .fromSerializer(new StringRedisSerializer()))
    //             .serializeValuesWith(RedisSerializationContext
    //                     .SerializationPair
    //                     .fromSerializer(new GenericJackson2JsonRedisSerializer()));


    //     return RedisCacheManager.RedisCacheManagerBuilder
    //             .fromConnectionFactory(redisConnectionFactory)
    //             .cacheDefaults(configuration)
    //             .build();

    // }
}

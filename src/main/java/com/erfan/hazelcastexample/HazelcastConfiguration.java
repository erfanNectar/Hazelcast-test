package com.erfan.hazelcastexample;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableCaching
@Configuration
public class HazelcastConfiguration extends CachingConfigurerSupport {

    @Bean
    public Config hazelcastConfig() {
        return new ClasspathXmlConfig("hazelcast.xml");
    }
    @Bean
    @Override
    public org.springframework.cache.CacheManager cacheManager() {
        return new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance());
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }
    @Bean
    public HazelcastInstance hazelcastInstance() {
        return Hazelcast.newHazelcastInstance();
    }
}

package com.erfan.hazelcastexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class CustomCacheErrorHandler implements CacheErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomCacheErrorHandler.class);

    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        logger.error("Cache get error for key '{}'", key, exception);
    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        logger.error("Cache put error for key '{}' with value '{}'", key, value, exception);
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        logger.error("Cache evict error for key '{}'", key, exception);
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        logger.error("Cache clear error", exception);
    }
}

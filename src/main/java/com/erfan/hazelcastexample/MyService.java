package com.erfan.hazelcastexample;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class MyService {
    private final HazelcastInstance hazelcastInstance;

    public MyService(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Cacheable(value = "testErfan", key = "#key")
    public void getFromCache(String key) {
        System.out.println("Fetching data from the source for key: " + key);
        getDataFromMap(key);
    }

    @CacheEvict(value = "testErfan", key = "#key")
    public void evictCache(String key) {
        System.out.println("Evicting cache for key: " + key);
    }

    public void getDataFromMap(String mapName) {

        IMap<Object, Object> hazelcastMap = hazelcastInstance.getMap(mapName);
        Set<Object> keys = hazelcastMap.keySet();
        System.out.println("Keys in the map: " + keys);
        Collection<Object> values = hazelcastMap.values();
        System.out.println("Values in the map: " + values);
    }

}

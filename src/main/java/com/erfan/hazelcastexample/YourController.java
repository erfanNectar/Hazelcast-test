package com.erfan.hazelcastexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class YourController {

   private final MyService myService;

    public YourController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/data/{key}")
    public void getData(@PathVariable String key) {
        myService.getFromCache(key);
    }

    @GetMapping("/evict/{key}")
    public String evictCache(@PathVariable String key) {
        myService.evictCache(key);
        return "Cache evicted for key: " + key;
    }
}
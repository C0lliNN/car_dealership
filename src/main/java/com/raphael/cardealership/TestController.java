package com.raphael.cardealership;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping(path = "/hello")
    public Map<String, String> helloWorld() {
        return Map.of("message", "Hello World!");
    }
}

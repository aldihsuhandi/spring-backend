package com.project.spring.process.service.impl;

import com.project.spring.core.service.HelloController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerImpl implements HelloController {

    @Override
    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null) {
            name = "World";
        }
        return "Hello " + name + "!";
    }
}

package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

    @RequestMapping("/")
    public String home() {
    	String helloStr = "Hello World!";
        return helloStr;
    }
    
    @RequestMapping("/aopHome")
    public String aopHome(String name) {
    	String helloStr = "---"+name+"JrebelTest";
        return helloStr;
    }
}
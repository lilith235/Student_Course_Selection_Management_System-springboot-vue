package com.rainng.coursesystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {
    @RequestMapping("/")
    public String hello() {
        return "成功！！！";
    }

    @RequestMapping("/test")
    public Object test() {
        return "Hello";
    }
}

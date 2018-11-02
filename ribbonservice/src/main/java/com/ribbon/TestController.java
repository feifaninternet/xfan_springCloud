package com.ribbon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xfan
 * @date Created on 2018/3/31 -- 10:00
 * @desc
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "/xfan")
    public String test(@RequestParam String name){
        return testService.test(name);
    }
}

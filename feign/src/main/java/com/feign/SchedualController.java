package com.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xfan
 * @date Created on 2018/3/31 -- 12:02
 * @desc
 */
@RestController
public class SchedualController {

    @Resource
    private SchedualService schedualService;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualService.theClientFrom(name);
    }


}

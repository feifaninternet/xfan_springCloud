package com.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xfan
 * @date Created on 2018/3/31 -- 11:55
 * @desc Feign 消费者
 */
@FeignClient(value = "server-xfan",fallback = SchedualServiceImpl.class)
@Service
public interface SchedualService {

    @RequestMapping(value = "xfan",method = RequestMethod.GET)
    String theClientFrom(@RequestParam(value = "name") String name);

}

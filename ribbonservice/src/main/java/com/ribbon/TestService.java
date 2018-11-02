package com.ribbon;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xfan
 * @date Created on 2018/3/31 -- 9:58
 * @desc
 */
@Service
public class TestService {
    @Autowired
    RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "hiError")
    public String test(String name){
        return restTemplate.getForObject("http://server-xfan/xfan?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi," + name + ",sorry,error!";
    }
}

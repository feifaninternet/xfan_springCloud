package com.feign;

import org.springframework.stereotype.Component;

/**
 * @author xfan
 * @date Created on 2018/3/31 -- 16:57
 * @desc
 */
@Component
public class SchedualServiceImpl implements SchedualService {
    @Override
    public String theClientFrom(String name) {
        return "sorry" + name;
    }

}

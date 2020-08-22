package com.microservice.cloud.controller;

import com.microservice.cloud.config.RestTemplateConfig;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : nacos服务消费控制类
 * @Author : huzhiting
 * @Date: 2020-08-22 10:22
 */
@RestController
public class TestHelloController {

    @Resource
    private RestTemplateConfig restTemplateConfig;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplateConfig.restTemplate().getForObject("http://nacos-service-provider/echo/" + str, String.class);
    }

}

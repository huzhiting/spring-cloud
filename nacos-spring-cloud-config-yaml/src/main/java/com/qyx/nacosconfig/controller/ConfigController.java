package com.qyx.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : Nacos读取yaml控制类
 * @Author : huzhiting
 * @Date: 2020-08-28 10:51
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${search.url}")
    private String url;


    @RequestMapping("/get")
    public String get() {
        return url;
    }

}
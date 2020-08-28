package com.qyx.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : Nacos读取properties控制类
 * @Author : huzhiting
 * @Date: 2020-08-28 10:36
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache}")
    private boolean useLocalCache;


    @RequestMapping("/get/cache")
    public boolean get() {
        return useLocalCache;
    }
}
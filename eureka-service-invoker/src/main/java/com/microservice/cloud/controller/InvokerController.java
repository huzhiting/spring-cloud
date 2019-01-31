package com.microservice.cloud.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author huzhiting
 * @version 1.0
 * <p>
 * <p>
 * History:
 * <p>
 * Date                 Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018/12/17 17:55         huzhiting          1.0         To create
 * </p>
 * @see
 * @since
 */
@RestController
@Configuration
public class InvokerController {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/info")
    public String info(){
        return "hello eureka";
    }

    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(){
        RestTemplate restTemplate=getRestTemplate();
        String url="http://eureka-service-provider/user/1";
        //根据应用名称调用服务
        //String json=restTemplate.getForObject("http://localhost:9000/user/1",String.class);
        String json=restTemplate.getForObject(url,String.class);
        return json;
    }
}

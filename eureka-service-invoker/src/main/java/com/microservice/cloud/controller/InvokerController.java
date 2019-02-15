package com.microservice.cloud.controller;

import com.netflix.client.http.HttpResponse;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @RequestMapping(value = "/routerEx", method = RequestMethod.GET)
    public String routerEx() {
        RestTemplate restTemplate=getRestTemplate();
        ServiceInstance instance = this.loadBalancerClient.choose("eureka-service-provider");
        URI uri = URI.create(String.format("http://eureka-service-provider/user/1", instance.getHost(), instance.getPort()));
        System.out.println("===" + ":" + instance.getServiceId() + ":" + instance.getHost() + ":"
                + instance.getPort());// 打印当前调用服务的信息

//        List<ServiceInstance> instanceList= discoveryClient.getInstances("eureka-service-provider");
//        if(instanceList==null || instanceList.isEmpty()){
//            return "出错了~";
//        }
//        //获取服务器集群个数
//        int size=instanceList.size();
//        int reqCount=1;
//        int serviceIndex=reqCount % size;
//        URI uri=instanceList.get(serviceIndex).getUri();
        System.out.println("Target service uri = " + uri.toString());
        return restTemplate.getForObject(uri, String.class);
    }
}

package com.microservice.cloud.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
 * 2019/2/15 11:30         huzhiting          1.0         To create
 * </p>
 * @see
 * @since
 */
@FeignClient(name = "eureka-service-provider")
public interface InvokerApiFeign {

    @RequestMapping("/user/{userId}")
    public String getServiceProvider(@PathVariable(value = "userId") Integer userId);
}

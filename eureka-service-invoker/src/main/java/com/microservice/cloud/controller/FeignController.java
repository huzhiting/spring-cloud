package com.microservice.cloud.controller;

import com.microservice.cloud.feignapi.InvokerApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * 2019/2/15 12:42         huzhiting          1.0         To create
 * </p>
 * @see
 * @since
 */
@RestController
public class FeignController {

    @Autowired
    private InvokerApiFeign invokerApiFeign;

    @RequestMapping("/user/{userId}")
    public String getServiceProvider(@PathVariable Integer userId){
        return invokerApiFeign.getServiceProvider(userId);
    }


}

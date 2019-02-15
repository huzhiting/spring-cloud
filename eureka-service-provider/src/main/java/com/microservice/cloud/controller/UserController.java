package com.microservice.cloud.controller;

import com.microservice.cloud.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * 2018/12/17 17:26         huzhiting          1.0         To create
 * </p>
 * @see
 * @since
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable("userId") Integer userId){
        User user =new User(1,"zhangsan",20,serverPort);
        return user;
    }
}

package com.microservice.cloud.controller;

import com.microservice.cloud.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable("userId") Integer userId){
        User user =new User(1,"zhangsan",20);
        return user;
    }
}

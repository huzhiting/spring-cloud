package com.microservice.cloud.model;

import lombok.Data;

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
 * 2018/12/17 17:29         huzhiting          1.0         To create
 * </p>
 * @see
 * @since
 */
@Data
public class User {

    private Integer id;

    private String userName;

    private Integer age;

    private String port;

    public User(Integer id,String userName,Integer age,String port){
       this.id=id;
       this.userName=userName;
       this.age=age;
       this.port=port;
    }
}

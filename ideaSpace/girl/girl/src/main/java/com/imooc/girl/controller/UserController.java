package com.imooc.girl.controller;

import com.imooc.girl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        User u = new User();
        u.setName("Joey");
        u.setAge(28);
        u.setBirthday(new Date("1990/8/22"));
        u.setEmail(null);

        return u;
    }
}

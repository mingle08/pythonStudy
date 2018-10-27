package com.imooc.girl.controller;

import com.imooc.girl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("name", "thymeleaf");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public User test(ModelMap map){

        User u = new User();
        u.setName("Jack");

        return u;

    }
}

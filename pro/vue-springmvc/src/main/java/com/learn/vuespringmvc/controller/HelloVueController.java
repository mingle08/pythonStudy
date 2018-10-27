package com.learn.vuespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.vuespringmvc.model.Person;

@Controller
@RequestMapping("/hello")
public class HelloVueController {

	@RequestMapping("/index")
    public String homeHandler(){
        return "index";
    }

    @RequestMapping("/test")
    public String testHandler(){
        return "test";
    }

    /**
     * 使用JSON作为响应内容
     */

    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value="/getperson/{personID}",method=RequestMethod.GET)
     public @ResponseBody Person getPerson(@PathVariable int personID) {
        Person p = new Person();
        p.setName("Eric");
        p.setGender("male");
        p.setId(personID);
        return p;
    }
}

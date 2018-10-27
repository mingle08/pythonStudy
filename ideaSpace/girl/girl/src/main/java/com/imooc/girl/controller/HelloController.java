package com.imooc.girl.controller;


import com.imooc.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller // 需要使用模板thymeleaf
@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${cupSize}")
////    private String cupSize;
////
////    @Value("${age}")
////    private Integer age;
////
////    @Value("${content}")
////    private String content;
    @Autowired
    private Girl girl;

    @RequestMapping(value={"/say", "/speak"}, method = RequestMethod.GET)
    public String say(){
        return girl.getCupSize() + " " + girl.getAge();
//        return "index";
    }

    @RequestMapping(value="/smile/{id}", method = RequestMethod.GET)
    public String smile(@PathVariable("id") Integer id){
        return "id: " + id;
    }

    // http://localhost:8088/hello/cry?idStr=4
    @RequestMapping(value="/cry", method = RequestMethod.GET)
    public String cry(@RequestParam(value="idStr", required=false, defaultValue = "0") Integer id){
        return "id: " + id;
    }



}

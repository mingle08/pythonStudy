package com.imooc.girl.controller;

import com.imooc.girl.domain.Result;
import com.imooc.girl.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/getAjaxError")
    @ResponseBody
    public Result getAjaxError(){
        int a = 1 / 0;
        return ResultUtil.suc();
    }
}

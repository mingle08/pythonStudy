package com.imooc.girl.utils;

import com.imooc.girl.domain.Result;

public class ResultUtil {

    public static Result suc(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    public static Result suc(){
        return suc(null);
    }

    public static Result fail(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

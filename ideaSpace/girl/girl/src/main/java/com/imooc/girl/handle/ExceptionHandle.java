package com.imooc.girl.handle;

import com.imooc.girl.domain.Result;
import com.imooc.girl.exception.PrettyGirlException;
import com.imooc.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof PrettyGirlException){
            PrettyGirlException prettyGirlException = (PrettyGirlException) e;
            return ResultUtil.fail(prettyGirlException.getCode(), prettyGirlException.getMessage());
        }else{
            logger.error("【系统异常】{}", e);
            return ResultUtil.fail(-1, "未知错误！");
        }

    }
}

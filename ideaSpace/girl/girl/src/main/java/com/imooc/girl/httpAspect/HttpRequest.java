package com.imooc.girl.httpAspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpRequest {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);
//com.imooc.girl.controller.PrettyGirlController
    @Pointcut("execution(public * com.imooc.girl.controller.PrettyGirlController.*(..))")
    public void log(){
        logger.info("1111111");
    }

    @Before("log()")
    public void doBefore(){
        logger.info("2222222");
    }

    @After("log()")
    public void doAfter(){
        logger.info("333333");
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void afterReturning(Object obj){
        logger.info("response={}", obj.toString());
    }
}

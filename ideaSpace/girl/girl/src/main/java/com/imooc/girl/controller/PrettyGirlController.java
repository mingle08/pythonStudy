package com.imooc.girl.controller;

import com.imooc.girl.domain.PrettyGirl;
import com.imooc.girl.domain.Result;
import com.imooc.girl.repository.PrettyGirlRepository;
import com.imooc.girl.service.PrettyGirlService;

import com.imooc.girl.utils.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PrettyGirlController {

    private static final Logger logger = LoggerFactory.getLogger(PrettyGirlController.class);

    @Autowired
    private PrettyGirlService prettyGirlService;

    @Autowired
    private PrettyGirlRepository prettyGirlRepository;

    @GetMapping("/prettyGirls")
    public List<PrettyGirl> prettyGirlList(){
        System.out.println("prettyGirlList");

        logger.info("prettyGirlList---logger");
        return prettyGirlRepository.findAll();
    }

    @PostMapping("/prettyGirls")
    public Result<PrettyGirl> addPrettyGirl(@Valid PrettyGirl girl, BindingResult bindingResult){
//        Result<PrettyGirl> result = new Result<>();
        if(bindingResult.hasErrors()){
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
            return null;
//            return ResultUtil.fail(1, bindingResult.getFieldError().getDefaultMessage());

        }
//        result.setCode(0);
//        result.setMsg("success");
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
//        result.setData(prettyGirlRepository.save(girl));
//        return result;
        return ResultUtil.suc(prettyGirlRepository.save(girl));
    }

    // 查询一个女生
    @GetMapping(value = "/prettyGirls/{id}")
    public Optional<PrettyGirl> prettyGirlFindOne(@PathVariable("id") Integer id){
        // 原来的findOne(id)方法在2.0改成了findById(id)
        return prettyGirlRepository.findById(id);
    }

    // 更新
    @PutMapping("/prettyGirls/{id}")
    public PrettyGirl prettyGirlUpdate(@PathVariable("id") Integer id,
                                 @RequestParam("cupSize") String cupSize,
                                 @RequestParam("age") Integer age){
        PrettyGirl girl = new PrettyGirl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return prettyGirlRepository.save(girl);
    }

    // 删除
    @DeleteMapping("/prettyGirls/{id}")
    public void prettyGirlDelete(@PathVariable("id") Integer id){
        prettyGirlRepository.deleteById(id);
    }

    // 通过年龄查询女生列表
    @GetMapping("/prettyGirls/age/{age}")
    public List<PrettyGirl> prettyGirlsByAge(@PathVariable("age") Integer age){
        return prettyGirlRepository.findByAge(age);
    }

    @PostMapping("/prettyGirls/two")
    public void prettyGirlTwo(){
        prettyGirlService.insertTwo();
    }

    @GetMapping("prettyGirls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        prettyGirlService.getAge(id);
    }
}

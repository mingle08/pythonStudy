package com.imooc.girl.service.impl;

import com.imooc.girl.domain.PrettyGirl;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.PrettyGirlException;
import com.imooc.girl.repository.PrettyGirlRepository;
import com.imooc.girl.service.PrettyGirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrettyGirlServiceImpl implements PrettyGirlService {

    @Autowired
    private PrettyGirlRepository repository;

    @Override
    @Transactional
    public void insertTwo() {

        PrettyGirl girlA = new PrettyGirl();
        girlA.setCupSize("A");
        girlA.setAge(25);
        girlA.setMoney(160.2);
        repository.save(girlA);

        PrettyGirl girlB = new PrettyGirl();
        girlA.setCupSize("B");
        girlA.setAge(24);
        girlA.setMoney(220.2);
        repository.save(girlB);
    }

    @Override
    public void getAge(Integer id) throws Exception{

        Optional<PrettyGirl> girl = repository.findById(id);
        Integer age = girl.get().getAge();
        if(age < 10){
            // 返回 "你还在上小学吧？"
            throw new PrettyGirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            // 返回 "你可能在上初中"
            throw new PrettyGirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    @Override
    public Optional<PrettyGirl> findById(Integer id) {
        return repository.findById(id);
    }


}

package com.imooc.girl.service;

import com.imooc.girl.domain.PrettyGirl;

import java.util.Optional;

public interface PrettyGirlService {

    void insertTwo() ;
    void getAge(Integer id) throws Exception;

    Optional<PrettyGirl> findById(Integer id);
}

package com.imooc.girl.repository;

import com.imooc.girl.domain.PrettyGirl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrettyGirlRepository extends JpaRepository<PrettyGirl, Integer> {

    // 自定义按年龄查询
    public List<PrettyGirl> findByAge(Integer age);
}

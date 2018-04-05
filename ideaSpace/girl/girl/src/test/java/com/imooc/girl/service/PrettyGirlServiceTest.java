package com.imooc.girl.service;

import com.imooc.girl.domain.PrettyGirl;
import com.imooc.girl.service.PrettyGirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrettyGirlServiceTest {
    @Autowired
    private PrettyGirlService prettyGirlService;

    @Test
    public void findOneTest(){
        PrettyGirl girl = prettyGirlService.findById(5).get();
        Assert.assertEquals(new Integer(14), girl.getAge());
    }
}

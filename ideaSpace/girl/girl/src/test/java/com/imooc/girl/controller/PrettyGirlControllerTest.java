package com.imooc.girl.controller;

import com.imooc.girl.handle.ExceptionHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrettyGirlControllerTest {

//    @Autowired
//    private PrettyGirlController prettyGirlController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void prettyGirlList() throws Exception {
//        prettyGirlController.prettyGirlList();
        mvc.perform(MockMvcRequestBuilders.get("/prettyGirls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}
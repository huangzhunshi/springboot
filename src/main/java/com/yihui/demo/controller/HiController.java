package com.yihui.demo.controller;

import com.yihui.demo.config.PageHandConfig;
import com.yihui.demo.dao.CanalTestDAO;
import com.yihui.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value("${pageSize}")
    private Integer pageSize;

    @Autowired
    PageHandConfig pageHandConfig;

    @Autowired
    CanalTestDAO canalTestDAO;

    @RequestMapping("/hello")
    public String hello(){
        //return "hello world"+pageSize;
       return pageHandConfig.getIsPage()+"-"+pageHandConfig.getPageIndex()+"-"+pageHandConfig.getPageSize();
    }

    @RequestMapping("/getmessage")
    public Message<String> getMessage(){
        return Message.<String>builder().code(100).message("成功").data("哈哈").build();
    }


    @RequestMapping("daoTest")
    public Object daoTest(){
        return canalTestDAO.selectByPrimaryKey(2);
    }
}

package com.yihui.demo.service;

import com.yihui.demo.dao.CanalTestDAO;
import com.yihui.demo.model.CanalTestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private CanalTestDAO canalTestDAO;

    @Transactional
    public void InsertTest(){
        CanalTestDO canalTestDO_1=new CanalTestDO();
        canalTestDO_1.setcName("测试1");

        CanalTestDO canalTestDO_2=new CanalTestDO();
        canalTestDO_2.setcName("测试2");

        canalTestDAO.insert(canalTestDO_1);
        canalTestDAO.insert(canalTestDO_2);

    }
}

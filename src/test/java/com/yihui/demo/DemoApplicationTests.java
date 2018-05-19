package com.yihui.demo;

import com.yihui.demo.controller.HiController;
import com.yihui.demo.dao.CanalTestDAO;
import com.yihui.demo.model.CanalTest;
import com.yihui.demo.model.CanalTestDO;
import com.yihui.demo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private HiController hiController;

	@Autowired
	private CanalTestDAO canalTestDAO;

	@Autowired
	private TestService testService;

	/**
	 *
	 * 测试插入语句，成功后回滚，不进入数据库
	 */
	@Test
	@Transactional
	public void testCanlTestInsert(){
		CanalTestDO canalTestDO=new CanalTestDO();
		canalTestDO.setcName("测试111111");
		canalTestDAO.insert(canalTestDO);
	}

	@Test
	@Transactional
	public void testTestServiceInsert(){
		testService.InsertTest();
	}

	@Test
	public void contextLoads() {
		hiController.getMessage();
	}

	/**
	 * try-with-resources 写法
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		try (BufferedReader br =
					 new BufferedReader(new FileReader("/mywork/代码生成工具/generatorConfig.xml"))) {
			String str= br.readLine();
			System.out.println(str);
		}
	}
}

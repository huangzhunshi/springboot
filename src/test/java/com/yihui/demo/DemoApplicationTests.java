package com.yihui.demo;

import com.yihui.demo.controller.HiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private HiController hiController;

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

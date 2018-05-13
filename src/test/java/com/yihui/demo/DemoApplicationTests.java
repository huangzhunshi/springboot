package com.yihui.demo;

import com.yihui.demo.controller.HiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private HiController hiController;

	@Test
	public void contextLoads() {
		hiController.getMessage();
	}

}

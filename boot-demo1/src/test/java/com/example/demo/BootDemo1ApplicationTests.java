package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemo1ApplicationTests {
	private MockMvc mvc;
	@Before
	public  void Before() {
		this.mvc=MockMvcBuilders.standaloneSetup(new DemoController()).build();
	}
	@Test
	public void contextLoads() throws Exception {
		RequestBuilder requestBuilder=get("/index");
		mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("helloworld"));
	}

}
















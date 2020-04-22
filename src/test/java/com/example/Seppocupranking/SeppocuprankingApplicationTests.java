package com.example.Seppocupranking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Seppocupranking.web.JoukkueController;

@RunWith(SpringRunner.class)
@SpringBootTest
class SeppocuprankingApplicationTests {

	@Autowired
	private JoukkueController controller;
	//Test if context loads
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}

package com.csmarton;

import com.csmarton.service.CashRegisterFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PesoApplicationTests {

	@Autowired
	CashRegisterFactory cashRegisterFactory;

	@Test
	public void contextLoads() {
	}
}

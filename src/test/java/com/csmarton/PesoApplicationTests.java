package com.csmarton;

import com.csmarton.model.ChangeResult;
import com.csmarton.service.CashRegister;
import com.csmarton.service.CashRegisterFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.truth.Truth.assertWithMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PesoApplicationTests {

	@Autowired
	CashRegisterFactory cashRegisterFactory;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHufBefore2008() {
		CashRegister hufCashRegister = cashRegisterFactory.buildCashRegister(CashRegisterFactory.HUF_BEFORE_2008);

		ChangeResult result = hufCashRegister.getBanknotesForValue(248);

		assertWithMessage("Banknotes do not match").that(result.getRemain()).isEqualTo(9);
	}

	@Test
	public void testHufAfter2008() {
		CashRegister hufCashRegister = cashRegisterFactory.buildCashRegister(CashRegisterFactory.HUF_AFTER_2008);

		ChangeResult result = hufCashRegister.getBanknotesForValue(248);

		assertWithMessage("Banknotes do not match").that(result.getRemain()).isEqualTo(9);
	}
}

package com.csmarton.service;

import com.google.common.collect.ImmutableMap;

import com.csmarton.service.impl.CashRegisterCUC;
import com.csmarton.service.impl.CashRegisterHUFAfter2008;
import com.csmarton.service.impl.CashRegisterHUFPre2008;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CashRegisterFactory {
    public static final String HUF_BEFORE_2008 = "hufBefore2008";
    public static final String HUF_AFTER_2008 = "hufAfter2008";
    public static final String CUC = "cuc";

    Map<String, CashRegister> registers = ImmutableMap.<String, CashRegister>builder()
            .put(HUF_BEFORE_2008, new CashRegisterHUFPre2008())
            .put(HUF_AFTER_2008, new CashRegisterHUFAfter2008())
            .put(CUC, new CashRegisterCUC())
            .build();


    public CashRegister buildCashRegister(String key) {
        return registers.get(key);
    }

}

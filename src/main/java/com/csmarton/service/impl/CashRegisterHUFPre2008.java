package com.csmarton.service.impl;

import com.google.common.collect.Maps;

import com.csmarton.service.CashRegister;

import java.util.Map;

public class CashRegisterHUFPre2008 extends CashRegister {
    private Map<Integer, Integer> banknotesMap = Maps.newLinkedHashMap();

    public CashRegisterHUFPre2008() {
        initBankNotes();
    }

    private void initBankNotes() {
        banknotesMap.put(20000, 1);
        banknotesMap.put(10000, 1);
        banknotesMap.put(5000, 1);
        banknotesMap.put(2000, 1);
        banknotesMap.put(1000, 1);
        banknotesMap.put(500, 1);
        banknotesMap.put(200, 1);
        banknotesMap.put(100, 1);
        banknotesMap.put(50, 4);
        banknotesMap.put(20, 1);
        banknotesMap.put(10, 1);
        banknotesMap.put(5, 1);
        banknotesMap.put(2, 1);
        banknotesMap.put(1, 1);
    }

    @Override
    public Map<Integer, Integer> getBanknotesMap() {
        return banknotesMap;
    }

    @Override
    public String getCurrencyName() {
        return "HUF";
    }
}

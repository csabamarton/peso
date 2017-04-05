package com.csmarton.service.impl;

import com.google.common.collect.Maps;

import com.csmarton.service.CashRegister;

import java.util.Map;

public class CashRegisterCUC extends CashRegister {

    private Map<Integer, Integer> banknotesMap = Maps.newLinkedHashMap();

    public CashRegisterCUC() {
        initBankNotes();
    }

    private void initBankNotes() {
        banknotesMap.put(100, 1);
        banknotesMap.put(50, 4);
        banknotesMap.put(20, 1);
        banknotesMap.put(10, 1);
        banknotesMap.put(5, 1);
        banknotesMap.put(3, 1);
        banknotesMap.put(1, 1);
    }

    @Override
    public Map<Integer, Integer> getBanknotesMap() {
        return banknotesMap;
    }

    @Override
    public String getCurrencyName() {
        return "CUC";
    }
}

package com.csmarton.service.impl;

import com.google.common.collect.Maps;

import com.csmarton.model.ChangeResult;
import com.csmarton.service.CashRegister;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class CashRegisterHUFAfter2008 extends CashRegister {
    private static Logger logger = LogManager.getLogger();

    private Map<Integer, Integer> banknotesMap = Maps.newLinkedHashMap();

    public CashRegisterHUFAfter2008() {
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
    }

    @Override
    public Map<Integer, Integer> getBanknotesMap() {
        return banknotesMap;
    }

    @Override
    public String getCurrencyName() {
        return "HUF";
    }

    @Override
    public ChangeResult getBanknotesForValue(int value) {

        logger.info("Need to round the value");
        int roundedValue = round(value);
        logger.info(value + " -> " + roundedValue);

        return super.getBanknotesForValue(roundedValue);
    }

    private int round(int value) {
        int last = value % 10;
        int base = value - last;

        if (last <= 2) {
            return base;
        } else if (last < 5 || last <= 7) {
            return base + 5;
        } else {
            return base + 10;
        }
    }
}

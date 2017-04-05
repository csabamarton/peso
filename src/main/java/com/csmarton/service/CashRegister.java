package com.csmarton.service;

import com.google.common.collect.Maps;

import com.csmarton.exception.NoBanknoteException;
import com.csmarton.model.ChangeResult;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class CashRegister {

    @JsonGetter
    protected abstract Map<Integer, Integer> getBanknotesMap();

    @JsonGetter
    public abstract String getCurrencyName();

    public ChangeResult getBanknotesForValue(int value) {

        Map<Integer, Integer> usedBanknotesMap = Maps.newHashMap();

        try {
            while (value > 0) {
                int biggestLess = findBiggestLess(value);
                Integer numOfBanknote = getBanknotesMap().get(biggestLess);
                int div = value / biggestLess;

                if (numOfBanknote < div) {
                    div = numOfBanknote;
                }

                int remain = value - div * biggestLess;
                Integer numOfUsage = usedBanknotesMap.get(biggestLess);
                usedBanknotesMap.put(biggestLess, numOfUsage == null ? div : numOfUsage + div);

                if (numOfBanknote - div == 0) {
                    getBanknotesMap().remove(biggestLess);
                } else {
                    getBanknotesMap().put(biggestLess, numOfBanknote - div);
                }

                value = remain;
            }
        } catch (NoBanknoteException e) {
            System.out.println("Remained value:" + e.value);
        }

        System.out.println(usedBanknotesMap);

        return new ChangeResult(usedBanknotesMap, value);
    }

    private int findBiggestLess(int value) throws NoBanknoteException {
        Set<Integer> bankNotes = getBanknotesMap().keySet();
        Iterator<Integer> iterator = bankNotes.iterator();

        while (iterator.hasNext()) {
            Integer bankNote = iterator.next();

            if (value > bankNote) {
                return bankNote;
            }

        }

        throw new NoBanknoteException(value);
    }
}

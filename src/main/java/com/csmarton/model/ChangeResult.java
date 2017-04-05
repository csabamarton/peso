package com.csmarton.model;

import com.google.common.collect.Maps;

import java.util.Map;

public class ChangeResult {
    private Map<Integer, Integer> usedBanknotesMap = Maps.newHashMap();
    private Integer remain;

    public ChangeResult(Map<Integer, Integer> usedBanknotesMap, Integer remain) {
        this.usedBanknotesMap = usedBanknotesMap;
        this.remain = remain;
    }

    public ChangeResult() {
    }

    public Map<Integer, Integer> getUsedBanknotesMap() {
        return usedBanknotesMap;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setUsedBanknotesMap(Map<Integer, Integer> usedBanknotesMap) {
        this.usedBanknotesMap = usedBanknotesMap;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }
}

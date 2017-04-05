package com.csmarton.model;

import com.csmarton.validation.RegisterKey;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ChangeRequest {
    @NotNull
    @RegisterKey
    private String registerKey;

    @NotNull
    @Min(1)
    @Digits(integer=6, fraction=0, message="{javax.validation.constraints.Digits.message}")
    private Integer value;

    public ChangeRequest() {
    }

    public ChangeRequest(String registerKey, Integer value) {
        this.registerKey = registerKey;
        this.value = value;
    }

    public String getRegisterKey() {
        return registerKey;
    }

    public Integer getValue() {
        return value;
    }

    public void setRegisterKey(String registerKey) {
        this.registerKey = registerKey;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

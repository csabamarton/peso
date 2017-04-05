package com.csmarton.exception;

public class NoBanknoteException extends Exception {
    public Integer value;

    public NoBanknoteException(Integer value) {
        this.value = value;
    }
}

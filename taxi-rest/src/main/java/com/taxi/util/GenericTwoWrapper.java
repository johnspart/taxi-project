package com.taxi.util;
public class GenericTwoWrapper<T, Z> {
    private T valueOne;
    private Z valueTwo;
    public T getValueOne() {
        return valueOne;
    }
    public void setValueOne(T valueOne) {
        this.valueOne = valueOne;
    }
    public Z getValueTwo() {
        return valueTwo;
    }
    public void setValueTwo(Z valueTwo) {
        this.valueTwo = valueTwo;
    }
}

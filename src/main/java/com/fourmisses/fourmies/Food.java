package com.fourmisses.fourmies;

public class Food {
    int stock;
    int decreaseValue = 20;

    public int decrease() {
        stock -= decreaseValue;
        return decreaseValue;
    }
}

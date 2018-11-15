package com.example.piotrek.currencycalculator.Model;

/**
 * Created by Piotrek on 10/16/2018.
 */

public class Currency {
    private String code;
    private String name;
    private  int multipler;
    private double rate;

    public int getMultipler() {
        return multipler;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public void setMultipler(int multipler) {
        this.multipler = multipler;
    }

    public Currency(String name,int multipler, String code, double rate) {
        this.code = code;
        this.name = name;
        this.multipler = multipler;
        this.rate = rate;
    }
}


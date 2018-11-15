package com.example.piotrek.currencycalculator.controller;

import java.util.List;
import com.example.piotrek.currencycalculator.Model.Currency;

import javax.xml.transform.Result;

/**
 * Created by Piotrek on 10/16/2018.
 */

public class Calculator {
    private List<Currency> currencyList;

//    public Calculator( List currencyyList) {
//        this.currencyList = currencyyList;
//    }

    public double count(Currency currencyfrom,Currency currencyto,Double amount){
        Double result;
       result = amount*((currencyto.getMultipler()/currencyto.getRate())/(currencyfrom.getMultipler()/currencyfrom.getRate()));
        //result = amount*((currencyfrom.getRate()/currencyfrom.getMultipler())/(currencyto.getRate()/currencyto.getMultipler()));
        return result;
    }
}

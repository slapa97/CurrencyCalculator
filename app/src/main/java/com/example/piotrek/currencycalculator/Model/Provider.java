package com.example.piotrek.currencycalculator.Model;

import com.example.piotrek.currencycalculator.Model.Currency;

import java.util.List;

/**
 * Created by Piotrek on 10/16/2018.
 */

public interface Provider {
    public List<Currency> get_data();
}

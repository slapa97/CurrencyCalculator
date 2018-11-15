package com.example.piotrek.currencycalculator.Model;

import com.example.piotrek.currencycalculator.Model.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 10/16/2018.
 */

public class CurrencyCollection {
    private List<Currency> lista = new ArrayList<Currency>();
    //   ??????      private List<Currency> lista;


        public Currency getCurrencyByName(String currencyName) {
            for (Currency currency : lista) {
                if (currency.getName().equals(currencyName)) {
                    return currency;
                }
            }
            return null;
        }
    public List<String> get_curr_list_by_name() {
        List<String> by_name=new ArrayList<String>();


        for(int i=0;i<lista.size();i++){
            by_name.add(lista.get(i).getName());
        }
        return by_name;
    }

    public List<Currency> getLista() {
        return lista;
    }
    public CurrencyCollection(List<Currency> lista) {
        this.lista = lista;
    }
}

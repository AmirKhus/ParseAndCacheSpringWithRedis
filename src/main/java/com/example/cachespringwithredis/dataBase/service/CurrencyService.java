package com.example.cachespringwithredis.dataBase.service;

import com.example.cachespringwithredis.model.CurrencyRate;

import java.util.List;

public interface CurrencyService {
    void saveCurrencyRate(CurrencyRate currencyRate);
    CurrencyRate getCurrencyById(String id);
    List<CurrencyRate> getAllCurrency();
    void saveListCurrencyRate(List<CurrencyRate> currencyRate);
}

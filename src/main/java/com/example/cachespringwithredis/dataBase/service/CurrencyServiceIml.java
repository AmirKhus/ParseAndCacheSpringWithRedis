package com.example.cachespringwithredis.dataBase.service;

import com.example.cachespringwithredis.dataBase.repository.CurrencyRepository;
import com.example.cachespringwithredis.exception.NotFoundEntityInDBException;
import com.example.cachespringwithredis.model.CurrencyRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CurrencyServiceIml implements CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public CurrencyRate getCurrencyById(String id) {
        Optional<CurrencyRate> currencyRateOptional = currencyRepository.findById(id);
        if (currencyRateOptional.isPresent()) {
            CurrencyRate currencyRate = currencyRateOptional.get();
            log.info("Currency rate by id ->{}", currencyRate);
            return currencyRateOptional.get();
        } else {
            log.error("Currency rate by id ->{} in MongoDB not fount", id);
            throw new NotFoundEntityInDBException("Currency rate by id ->" + id + " in MongoDB not fount");
        }
    }

    @Override
    public List<CurrencyRate> getAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public void saveCurrencyRate(CurrencyRate currencyRate) {
        log.info("Currency rate {}, update in mongoDB", currencyRate);
        currencyRepository.save(currencyRate);
    }

    @Override
    public void saveListCurrencyRate(List<CurrencyRate> currencyRate) {
        log.info("Currency rate {}, update in mongoDB", currencyRate);
        currencyRepository.saveAll(currencyRate);
    }
}

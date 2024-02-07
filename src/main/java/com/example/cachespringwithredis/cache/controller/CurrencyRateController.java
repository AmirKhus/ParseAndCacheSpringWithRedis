package com.example.cachespringwithredis.cache.controller;

import com.example.cachespringwithredis.cache.repository.CurrencyRateRepository;
import com.example.cachespringwithredis.model.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@EnableCaching
public class CurrencyRateController {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @GetMapping()
    public List<CurrencyRate> getPriceCurrency() {
        return currencyRateRepository.findAll();
    }


    @GetMapping("/{currentName}")
    @Cacheable(key = "#currentName", value = "CurrencyRate")
    public CurrencyRate getByCurrentName(@PathVariable String currentName) {
        return currencyRateRepository.findByCurrentName("USD");
    }

    @PostMapping("/create_current_rate/{currencyRateName}")
//    @Cacheable(key = "#currencyRateName", value = "CurrencyRate")
    public CurrencyRate post(@PathVariable String currencyRateName) {
        return currencyRateRepository.save(currencyRateName);
    }


    @DeleteMapping("delete_current_rate/{currentName}")
    public String delete(@PathVariable String currentName) {
        return currencyRateRepository.deleteByCurrentName(currentName);
    }
}

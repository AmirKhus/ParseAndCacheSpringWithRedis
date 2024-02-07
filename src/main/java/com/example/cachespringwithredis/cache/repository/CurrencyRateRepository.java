package com.example.cachespringwithredis.cache.repository;

import com.example.cachespringwithredis.dataBase.service.CurrencyServiceIml;
import com.example.cachespringwithredis.model.CurrencyRate;
import com.example.cachespringwithredis.parser.service.CurrencyRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Repository
public class CurrencyRateRepository {
    public static final String HASH_KEY = "CurrencyRate";
    @Autowired
    private RedisTemplate template;
    @Autowired
    private CurrencyRateService currencyRateService;
    @Autowired
    private CurrencyServiceIml currencyServiceIml;

    public CurrencyRate save(String currencyRateName) {
        log.info("Current {} save", currencyRateName);
        CurrencyRate currencyRate = currencyRateService.getCurrencyRate(currencyRateName,LocalDate.now());
        currencyServiceIml.saveCurrencyRate(currencyRate);
//        template.opsForHash().put(HASH_KEY, currencyRate.getName(), currencyRate);
        return currencyRate;
//        return null;
    }

    public List<CurrencyRate> findAll() {
        log.info("Find all current");
//        return template.opsForHash().values(HASH_KEY);
        return currencyServiceIml.getAllCurrency();
    }

    public CurrencyRate findByCurrentName(String currentName) {
        log.info("Find by current name {}", currentName);
        return (CurrencyRate) template.opsForHash().get(HASH_KEY, currentName);
    }

    public String deleteByCurrentName(String currentName) {
        log.info("Current {} deleted", currentName);
        template.opsForHash().delete(HASH_KEY, currentName);
        return "CurrencyRate object delete";
    }
}

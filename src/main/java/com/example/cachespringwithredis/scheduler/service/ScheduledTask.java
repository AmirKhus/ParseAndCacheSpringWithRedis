package com.example.cachespringwithredis.scheduler.service;

import com.example.cachespringwithredis.cache.controller.CurrencyRateController;
import com.example.cachespringwithredis.model.CurrencyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ScheduledTask {

    @Autowired
    CurrencyRateController currencyRateController;

    @Scheduled(cron = "10 0 15 * * 1,2,3,4,5", zone = "Europe/Moscow")
    public void schedule() {
        log.info("Start schedule for check update currency rate");
        List<String> currency = Arrays.stream(CurrencyEnum.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        for (String currencyName : currency) {
            currencyRateController.post(currencyName);
        }
        log.info("Stop schedule  for check update currency rate");
    }
}

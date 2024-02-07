package com.example.cachespringwithredis.parser.parser;

import com.example.cachespringwithredis.model.CurrencyRate;

import java.util.List;

public interface CurrencyRateParser {
    List<CurrencyRate> parse(String ratesAsString);
}

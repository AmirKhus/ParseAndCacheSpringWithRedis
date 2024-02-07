package com.example.cachespringwithredis.dataBase.repository;

import com.example.cachespringwithredis.model.CurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends MongoRepository<CurrencyRate, String> {
}
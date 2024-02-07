package com.example.cachespringwithredis.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("CurrencyRate")
public class CurrencyRate implements Serializable {
    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
}
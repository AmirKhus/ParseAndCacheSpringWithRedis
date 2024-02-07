package com.example.cachespringwithredis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
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
    private static final long serialVersionUID = -3470288071173159948L;
    @Id
    String id;
    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
}
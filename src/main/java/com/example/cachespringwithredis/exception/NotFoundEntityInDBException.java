package com.example.cachespringwithredis.exception;

public class NotFoundEntityInDBException extends RuntimeException {
    public NotFoundEntityInDBException(String s) {
        System.out.println(s);
    }
}

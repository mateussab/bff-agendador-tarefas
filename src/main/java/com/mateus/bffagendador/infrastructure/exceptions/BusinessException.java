package com.mateus.bffagendador.infrastructure.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensage){
        super(mensage);
    }

    public BusinessException(String mensage, Throwable cause){
        super(mensage,cause);
    }
}

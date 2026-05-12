package com.mateus.bffagendador.infrastructure.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String mensage){
        super(mensage);
    }

    public UnauthorizedException(String mensage, Throwable cause){
        super(mensage,cause);
    }
}

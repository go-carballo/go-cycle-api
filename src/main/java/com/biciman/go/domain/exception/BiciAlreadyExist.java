package com.biciman.go.domain.exception;

public class BiciAlreadyExist extends RuntimeException {
    public BiciAlreadyExist(String message) {
        super("La bicicleta ya existe: " + message);
    }
}

package com.biciman.go.domain.exception;

public class BiciNotFound extends RuntimeException {
    public BiciNotFound(long message) {
        super("Bici not found: " + message);
    }


}

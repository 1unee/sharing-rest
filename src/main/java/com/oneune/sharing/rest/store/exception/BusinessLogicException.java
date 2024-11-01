package com.oneune.sharing.rest.store.exception;

public class BusinessLogicException extends RuntimeException {

    public BusinessLogicException() {
        super("A business logic exception");
    }

    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(Exception e) {
        super(e);
    }

    public BusinessLogicException(String message, Exception e) {
        super(message, e);
    }
}

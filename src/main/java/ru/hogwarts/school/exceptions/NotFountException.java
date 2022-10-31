package ru.hogwarts.school.exceptions;

public class NotFountException extends  RuntimeException{
    public NotFountException() {
    }

    public NotFountException(String message) {
        super(message);
    }

    public NotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFountException(Throwable cause) {
        super(cause);
    }

    public NotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

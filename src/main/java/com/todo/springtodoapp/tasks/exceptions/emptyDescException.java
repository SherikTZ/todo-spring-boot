package com.todo.springtodoapp.tasks.exceptions;

public class emptyDescException extends IllegalArgumentException {

    public emptyDescException(String msg) {
        super(msg);
    }

}

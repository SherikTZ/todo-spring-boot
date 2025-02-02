package com.todo.springtodoapp.tasks.exceptions;

public class emptyTitleException extends IllegalArgumentException {
    public emptyTitleException(String msg) {
        super(msg);
    }
}

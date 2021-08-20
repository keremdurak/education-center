package com.keremdurak.javadeveloperchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseNotDeleteException extends RuntimeException {

    public CourseNotDeleteException(String message) {
        super(message);
    }
}

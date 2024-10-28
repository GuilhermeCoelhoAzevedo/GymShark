package com.gca.gymShark.Exercise;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exercise not found")
public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException() {
        super("Exercise not found");
    }

    public ExerciseNotFoundException(String message) {
        super(message);
    }
}

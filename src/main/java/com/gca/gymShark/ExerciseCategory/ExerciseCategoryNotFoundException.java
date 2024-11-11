package com.gca.gymShark.ExerciseCategory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exercise category not found")
public class ExerciseCategoryNotFoundException extends RuntimeException {
    public ExerciseCategoryNotFoundException() {
        super("Exercise category not found");
    }

    public ExerciseCategoryNotFoundException(String message) {
        super(message);
    }
}

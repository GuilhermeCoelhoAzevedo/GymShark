package com.gca.gymShark.ExerciseSet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Exercise set not found")
public class ExerciseSetNotFoundException extends RuntimeException {
    public ExerciseSetNotFoundException() {
    super("Exercise set not found");
  }

    public ExerciseSetNotFoundException(String message) {
        super(message);
    }
}

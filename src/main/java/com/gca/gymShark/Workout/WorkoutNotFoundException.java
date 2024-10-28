package com.gca.gymShark.Workout;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Workout not found")
public class WorkoutNotFoundException extends RuntimeException {
    public WorkoutNotFoundException() {
        super("Workout not found");
    }

    public WorkoutNotFoundException(String message) {
        super(message);
    }
}

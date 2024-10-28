package com.gca.gymShark.WorkoutExercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Workout exercise not found")
public class WorkoutExerciseNotFoundException extends RuntimeException {
    public WorkoutExerciseNotFoundException() {
        super("Workout exercise not found");
    }

    public WorkoutExerciseNotFoundException(String message) {
        super(message);
    }
}

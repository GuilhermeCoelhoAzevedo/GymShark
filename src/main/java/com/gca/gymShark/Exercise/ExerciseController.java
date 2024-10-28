package com.gca.gymShark.Exercise;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Exercise", description = "Exercise management APIs")
@RestController
@RequestMapping("api/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Operation(summary = "Retrieve all exercises")
    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){
        List<Exercise> exercises = exerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve exercise by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable long id) {
        Exercise exercise = exerciseService.getExercise(id);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @Operation(summary = "Create exercise")
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise createdExercise = exerciseService.createExercise(exercise);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }

    @Operation(summary = "Update exercise by Id")
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable long id, @RequestBody Exercise exercise) {
        Exercise updatedExercise = exerciseService.updateExercise(id, exercise);
        return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
    }

    @Operation(summary = "Delete exercise by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable long id) {
        exerciseService.deleteExercise(id);
        return new ResponseEntity<>("Exercise successfully deleted!", HttpStatus.OK);
    }
}

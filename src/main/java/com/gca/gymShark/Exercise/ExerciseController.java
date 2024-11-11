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

    @CrossOrigin
    @Operation(summary = "Retrieve all exercises")
    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){
        List<Exercise> exercises = exerciseService.getAll();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Retrieve exercise by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable long id) {
        Exercise exercise = exerciseService.get(id);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Create exercise")
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@ModelAttribute Exercise exercise) {
        Exercise createdExercise = exerciseService.create(exercise);
        return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
    }

    @CrossOrigin
    @Operation(summary = "Update exercise by Id")
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable long id, @ModelAttribute Exercise exercise) {
        Exercise updatedExercise = exerciseService.update(id, exercise);
        return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Delete exercise by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable long id) {
        exerciseService.delete(id);
        return new ResponseEntity<>("Exercise successfully deleted!", HttpStatus.OK);
    }
}

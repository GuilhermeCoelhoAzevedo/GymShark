package com.gca.gymShark.WorkoutExercise;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Workout Exercise", description = "Workout exercise management APIs")
@RestController
@RequestMapping("api/workoutExercises")
public class WorkoutExerciseController {
    private final WorkoutExerciseService workoutExerciseService;

    public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }

    @Operation(summary = "Retrieve all workout exercises")
    @GetMapping
    public ResponseEntity<List<WorkoutExercise>> getAllWorkoutExercises(){
        List<WorkoutExercise> workoutExercises = workoutExerciseService.getAllWorkoutExercises();
        return new ResponseEntity<>(workoutExercises, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve workout exercise by Id")
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutExercise> getWorkoutExercise(@PathVariable long id) {
        WorkoutExercise workoutExercise = workoutExerciseService.getWorkoutExercise(id);
        return new ResponseEntity<>(workoutExercise, HttpStatus.OK);
    }

    @Operation(summary = "Create workout exercise")
    @PostMapping
    public ResponseEntity<WorkoutExercise> createWorkoutExercise(@RequestBody WorkoutExercise workoutExercise) {
        WorkoutExercise createdWorkoutExercise = workoutExerciseService.createWorkoutExercise(workoutExercise);
        return new ResponseEntity<>(createdWorkoutExercise, HttpStatus.CREATED);
    }

    @Operation(summary = "Update workout exercise by Id")
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutExercise> updateWorkoutExercise(@PathVariable long id, @RequestBody WorkoutExercise workoutExercise) {
        WorkoutExercise updatedWorkoutExercise = workoutExerciseService.updateWorkoutExercise(id, workoutExercise);
        return new ResponseEntity<>(updatedWorkoutExercise, HttpStatus.OK);
    }

    @Operation(summary = "Delete workout exercise by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkoutExercise(@PathVariable long id) {
        workoutExerciseService.deleteWorkoutExercise(id);
        return new ResponseEntity<>("Workout exercise successfully deleted!", HttpStatus.OK);
    }
}

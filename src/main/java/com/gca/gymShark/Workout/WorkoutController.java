package com.gca.gymShark.Workout;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Workout", description = "Workout management APIs")
@RestController
@RequestMapping("api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @Operation(summary = "Retrieve all workouts")
    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        List<Workout> workouts = workoutService.getAllWorkouts();
        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve workout by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkout(@PathVariable long id) {
        Workout workout = workoutService.getWorkout(id);
        return new ResponseEntity<>(workout, HttpStatus.OK);
    }

    @Operation(summary = "Create workout")
    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout createdWorkout = workoutService.createWorkout(workout);
        return new ResponseEntity<>(createdWorkout, HttpStatus.CREATED);
    }

    @Operation(summary = "Update workout by Id")
    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable long id, @RequestBody Workout workout) {
        Workout updatedWorkout = workoutService.updateWorkout(id, workout);
        return new ResponseEntity<>(updatedWorkout, HttpStatus.OK);
    }

    @Operation(summary = "Delete workout by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable long id) {
        workoutService.deleteWorkout(id);
        return new ResponseEntity<>("Workout successfully deleted!", HttpStatus.OK);
    }
}

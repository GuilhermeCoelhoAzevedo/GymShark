package com.gca.gymShark.ExerciseSet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Exercise Set", description = "Exercise set management APIs")
@RestController
@RequestMapping("api/exerciseSets")
public class ExerciseSetController {
    private final ExerciseSetService exerciseSetService;

    public ExerciseSetController(ExerciseSetService exerciseSetService) {
        this.exerciseSetService = exerciseSetService;
    }

    @Operation(summary = "Retrieve all exercise sets")
    @GetMapping
    public ResponseEntity<List<ExerciseSet>> getAllExerciseSets(){
        List<ExerciseSet> exerciseSets = exerciseSetService.getAllExerciseSets();
        return new ResponseEntity<>(exerciseSets, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve exercise set by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseSet> getExerciseSet(@PathVariable long id) {
        ExerciseSet exerciseSet = exerciseSetService.getExerciseSet(id);
        return new ResponseEntity<>(exerciseSet, HttpStatus.OK);
    }

    @Operation(summary = "Create exercise set")
    @PostMapping
    public ResponseEntity<ExerciseSet> createExerciseSet(@RequestBody ExerciseSet exerciseSe) {

        ExerciseSet createdExerciseSet = exerciseSetService.createExerciseSet(exerciseSe);
        return new ResponseEntity<>(createdExerciseSet, HttpStatus.CREATED);
    }

    @Operation(summary = "Update exercise set by Id")
    @PutMapping("/{id}")
    public ResponseEntity<ExerciseSet> updateExerciseSet(@PathVariable long id, @RequestBody ExerciseSet exerciseSet) {
        ExerciseSet updatedExerciseSet = exerciseSetService.updateExerciseSet(id, exerciseSet);
        return new ResponseEntity<>(updatedExerciseSet, HttpStatus.OK);
    }

    @Operation(summary = "Delete exercise set by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExerciseSet(@PathVariable long id) {
        exerciseSetService.deleteExerciseSet(id);
        return new ResponseEntity<>("ExerciseSet successfully deleted!", HttpStatus.OK);
    }
}

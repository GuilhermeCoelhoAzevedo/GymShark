package com.gca.gymShark.ExerciseCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Tag(name = "ExerciseCategory", description = "ExerciseCategory management APIs")
@RestController
@RequestMapping("api/exerciseCategories")
public class ExerciseCategoryController {
    private final ExerciseCategoryService ExerciseCategoryService;

    public ExerciseCategoryController(ExerciseCategoryService ExerciseCategoryService) {
        this.ExerciseCategoryService = ExerciseCategoryService;
    }

    @CrossOrigin
    @Operation(summary = "Retrieve all exercise categories")
    @GetMapping
    public ResponseEntity<List<ExerciseCategory>> getAllExercises(){
        List<ExerciseCategory> exerciseCategories = ExerciseCategoryService.getAll();
        return new ResponseEntity<>(exerciseCategories, HttpStatus.OK);
    }

    @CrossOrigin
    @Operation(summary = "Retrieve ExerciseCategory by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseCategory> getExercise(@PathVariable long id) {
        ExerciseCategory exerciseCategory = ExerciseCategoryService.get(id);
        return new ResponseEntity<>(exerciseCategory, HttpStatus.OK);
    }
}

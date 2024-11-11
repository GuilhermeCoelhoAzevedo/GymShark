package com.gca.gymShark.ExerciseCategory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseCategoryService {
    private final ExerciseCategoryRepository ExerciseCategoryRepository;

    public ExerciseCategoryService(ExerciseCategoryRepository ExerciseCategoryRepository) {
        this.ExerciseCategoryRepository = ExerciseCategoryRepository;
    }

    public List<ExerciseCategory> getAll(){
        return ExerciseCategoryRepository.findAll();
    }

    public ExerciseCategory get(long id) {
        return ExerciseCategoryRepository.findById(id).orElseThrow(ExerciseCategoryNotFoundException::new);
    }
}

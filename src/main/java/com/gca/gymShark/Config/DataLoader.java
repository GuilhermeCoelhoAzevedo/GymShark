package com.gca.gymShark.Config;

import com.gca.gymShark.Exercise.Exercise;
import com.gca.gymShark.Exercise.ExerciseRepository;
import com.gca.gymShark.ExerciseCategory.ExerciseCategory;
import com.gca.gymShark.ExerciseCategory.ExerciseCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final ExerciseCategoryRepository exerciseCategoryRepository;
    private final ExerciseRepository exerciseRepository;

    public DataLoader(ExerciseCategoryRepository exerciseCategoryRepository, ExerciseRepository exerciseRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Load exercise categories data into the database
        ExerciseCategory dumbbellCategory = new ExerciseCategory("Dumbbell");

        exerciseCategoryRepository.save(new ExerciseCategory("Barbell"));
        exerciseCategoryRepository.save(dumbbellCategory);
        exerciseCategoryRepository.save(new ExerciseCategory("Machine"));
        exerciseCategoryRepository.save(new ExerciseCategory("Weighted Bodyweight"));
        exerciseCategoryRepository.save(new ExerciseCategory("Assisted Bodyweight"));
        exerciseCategoryRepository.save(new ExerciseCategory("Reps Only"));
        exerciseCategoryRepository.save(new ExerciseCategory("Cardio"));
        exerciseCategoryRepository.save(new ExerciseCategory("Duration"));

        exerciseRepository.save(new Exercise("Romanian Deadlift (Dumbbell)", dumbbellCategory, "Romanian Deadlift (Dumbbell) Instructions"));
    }
}

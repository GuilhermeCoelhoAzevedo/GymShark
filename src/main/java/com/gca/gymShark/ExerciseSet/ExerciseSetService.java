package com.gca.gymShark.ExerciseSet;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseSetService {
    private final ExerciseSetRepository exerciseSetRepository;

    public ExerciseSetService(ExerciseSetRepository exerciseSetRepository) {
        this.exerciseSetRepository = exerciseSetRepository;
    }

    public List<ExerciseSet> getAllExerciseSets(){
        return exerciseSetRepository.findAll();
    }

    public ExerciseSet getExerciseSet(long id) {
        return exerciseSetRepository.findById(id).orElseThrow(ExerciseSetNotFoundException::new);
    }

    public ExerciseSet createExerciseSet(ExerciseSet exerciseSet) {
        return exerciseSetRepository.save(exerciseSet);
    }

    public ExerciseSet updateExerciseSet(long id, ExerciseSet exerciseSet) {
        // Validate existence of the ID before updating
        if (!exerciseSetRepository.existsById(id)) {
            throw new ExerciseSetNotFoundException();
        }

        return exerciseSetRepository.save(exerciseSet);
    }

    public void deleteExerciseSet(long id) {
        // Validate existence of the ID before deleting
        if (!exerciseSetRepository.existsById(id)) {
            throw new ExerciseSetNotFoundException();
        }

        exerciseSetRepository.deleteById(id);
    }
}

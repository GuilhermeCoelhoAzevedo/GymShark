package com.gca.gymShark.Exercise;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAll(){
        return exerciseRepository.findAll();
    }

    public Exercise get(long id) {
        return exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);
    }

    public Exercise create(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise update(long id, Exercise exercise) {
        // Validate existence of the ID before updating
        if (!exerciseRepository.existsById(id)) {
            throw new ExerciseNotFoundException();
        }

        return exerciseRepository.save(exercise);
    }

    public void delete(long id) {
        // Validate existence of the ID before deleting
        if (!exerciseRepository.existsById(id)) {
            throw new ExerciseNotFoundException();
        }

        exerciseRepository.deleteById(id);
    }
}

package com.gca.gymShark.WorkoutExercise;

import com.gca.gymShark.Workout.Workout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutExerciseService {
    private final WorkoutExerciseRepository workoutExerciseRepository;

    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
    }

    public List<WorkoutExercise> getAllWorkoutExercises(){
        return workoutExerciseRepository.findAll();
    }

    public WorkoutExercise getWorkoutExercise(long id) {
        return workoutExerciseRepository.findById(id).orElseThrow(WorkoutExerciseNotFoundException::new);
    }

    public WorkoutExercise createWorkoutExercise(WorkoutExercise workoutExercise) {
        return workoutExerciseRepository.save(workoutExercise);
    }

    public WorkoutExercise updateWorkoutExercise(long id, WorkoutExercise workoutExercise) {
        // Validate existence of the ID before updating
        if (!workoutExerciseRepository.existsById(id)) {
            throw new WorkoutExerciseNotFoundException();
        }

        return workoutExerciseRepository.save(workoutExercise);
    }

    public void deleteWorkoutExercise(long id) {
        // Validate existence of the ID before deleting
        if (!workoutExerciseRepository.existsById(id)) {
            throw new WorkoutExerciseNotFoundException();
        }

        workoutExerciseRepository.deleteById(id);
    }
}

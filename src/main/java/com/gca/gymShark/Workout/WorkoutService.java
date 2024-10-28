package com.gca.gymShark.Workout;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public Workout getWorkout(long id) {
        return workoutRepository.findById(id).orElseThrow(WorkoutNotFoundException::new);
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(long id, Workout workout) {
        // Validate existence of the ID before updating
        if (!workoutRepository.existsById(id)) {
            throw new WorkoutNotFoundException();
        }

        return workoutRepository.save(workout);
    }

    public void deleteWorkout(long id) {
        // Validate existence of the ID before deleting
        if (!workoutRepository.existsById(id)) {
            throw new WorkoutNotFoundException();
        }

        workoutRepository.deleteById(id);
    }
}

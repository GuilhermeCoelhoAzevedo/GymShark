package com.gca.gymShark.ExerciseSet;

import com.gca.gymShark.Exercise.Exercise;
import com.gca.gymShark.WorkoutExercise.WorkoutExercise;
import jakarta.persistence.*;

@Entity
public class ExerciseSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int setNumber;

    private float weight;

    private int reps;

    @ManyToOne()
    private WorkoutExercise workoutExercise;

    public ExerciseSet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
    }
}

package com.gca.gymShark.WorkoutExercise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gca.gymShark.Exercise.Exercise;
import com.gca.gymShark.ExerciseSet.ExerciseSet;
import com.gca.gymShark.Workout.Workout;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String note;

    @ManyToOne()
    private Workout workout;

    @ManyToOne()
    private Exercise exercise;

    @JsonIgnore
    @OneToMany(mappedBy = "workoutExercise")
    private Set<ExerciseSet> exerciseSets;

    public WorkoutExercise() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Set<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(Set<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
}

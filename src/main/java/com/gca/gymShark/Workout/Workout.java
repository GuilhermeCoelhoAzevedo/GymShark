package com.gca.gymShark.Workout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gca.gymShark.WorkoutExercise.WorkoutExercise;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "workout")
    private Set<WorkoutExercise> workoutExercises;

    public Workout() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(Set<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
}

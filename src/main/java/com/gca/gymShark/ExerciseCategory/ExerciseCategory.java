package com.gca.gymShark.ExerciseCategory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gca.gymShark.Exercise.Exercise;
import jakarta.persistence.*;

import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "exerciseCategoryId")
@Entity
public class ExerciseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exerciseCategoryId;

    private String category;

    @OneToMany(mappedBy = "exerciseCategory")
    private Set<Exercise> exercises;

    public ExerciseCategory() {
    }

    public ExerciseCategory(String category) {
        this.category = category;
    }

    public long getExerciseCategoryId() {
        return exerciseCategoryId;
    }

    public void setExerciseCategoryId(long exerciseCategoryId) {
        this.exerciseCategoryId = exerciseCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}

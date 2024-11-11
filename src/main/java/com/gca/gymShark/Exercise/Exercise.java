package com.gca.gymShark.Exercise;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gca.gymShark.ExerciseCategory.ExerciseCategory;
import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "exerciseId")
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exerciseId;

    private String name;

    private String instructions;

    @ManyToOne
    @JoinColumn(name = "exerciseCategoryId", nullable=false)
    private ExerciseCategory exerciseCategory;

    public Exercise() {
    }

    public Exercise(String name, ExerciseCategory exerciseCategory) {
        this(name, exerciseCategory, "");
    }

    public Exercise(String name, ExerciseCategory exerciseCategory, String instructions) {
        this.name = name;
        this.instructions = instructions;
        this.exerciseCategory = exerciseCategory;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }
}

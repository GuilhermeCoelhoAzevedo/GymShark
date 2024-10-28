package com.gca.gymShark.Exercise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gca.gymShark.TemplateItem.TemplateItem;
import com.gca.gymShark.WorkoutExercise.WorkoutExercise;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String instructions;

    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "exercise")
    private Set<TemplateItem> templateItems;

    @JsonIgnore
    @OneToMany(mappedBy = "exercise")
    private Set<WorkoutExercise> workoutExercises;

    public Exercise() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<TemplateItem> getTemplateItems() {
        return templateItems;
    }

    public void setTemplateItems(Set<TemplateItem> templateItems) {
        this.templateItems = templateItems;
    }

    public Set<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(Set<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
}

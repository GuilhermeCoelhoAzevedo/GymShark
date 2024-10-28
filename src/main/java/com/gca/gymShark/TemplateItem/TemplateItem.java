package com.gca.gymShark.TemplateItem;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gca.gymShark.Exercise.Exercise;
import com.gca.gymShark.Template.Template;
import jakarta.persistence.*;

@Entity
public class TemplateItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="template_id")
    private Template template;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

    public TemplateItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}

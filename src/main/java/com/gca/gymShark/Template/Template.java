package com.gca.gymShark.Template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gca.gymShark.TemplateItem.TemplateItem;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "template")
    private Set<TemplateItem> templateItems;

    public Template() {
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

    public Set<TemplateItem> getTemplateItems() {
        return templateItems;
    }

    public void setTemplateItems(Set<TemplateItem> templateItems) {
        this.templateItems = templateItems;
    }

}

package com.gca.gymShark.Template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Template", description = "Template management APIs")
@RestController
@RequestMapping("api/templates")
public class TemplateController {
    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Operation(summary = "Retrieve all templates")
    @GetMapping
    public ResponseEntity<List<Template>> getAllTemplates(){
        List<Template> templates = templateService.getAllTemplates();
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve template by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplate(@PathVariable long id) {
        Template template = templateService.getTemplate(id);
        return new ResponseEntity<>(template, HttpStatus.OK);
    }

    @Operation(summary = "Create template")
    @PostMapping
    public ResponseEntity<Template> createTemplate(@RequestBody Template template) {
        Template createdTemplate = templateService.createTemplate(template);
        return new ResponseEntity<>(createdTemplate, HttpStatus.CREATED);
    }

    @Operation(summary = "Update template by Id")
    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable long id, @RequestBody Template template) {
        Template updatedTemplate = templateService.updateTemplate(id, template);
        return new ResponseEntity<>(updatedTemplate, HttpStatus.OK);
    }

    @Operation(summary = "Delete template by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTemplate(@PathVariable long id) {
        templateService.deleteTemplate(id);
        return new ResponseEntity<>("Template successfully deleted!", HttpStatus.OK);
    }
}

package com.gca.gymShark.TemplateItem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Template Item", description = "Template item management APIs")
@RestController
@RequestMapping("api/templateItems")
public class TemplateItemController {
    private final TemplateItemService templateItemService;

    public TemplateItemController(TemplateItemService templateItemService) {
        this.templateItemService = templateItemService;
    }

    @Operation(summary = "Retrieve all template items")
    @GetMapping
    public ResponseEntity<List<TemplateItem>> getAllTemplates(){
        List<TemplateItem> templates = templateItemService.getAllTemplates();
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve template item by Id")
    @GetMapping("/{id}")
    public ResponseEntity<TemplateItem> getTemplate(@PathVariable long id) {
        TemplateItem template = templateItemService.getTemplate(id);
        return new ResponseEntity<>(template, HttpStatus.OK);
    }

    @Operation(summary = "Create template item")
    @PostMapping
    public ResponseEntity<TemplateItem> createTemplate(@RequestBody Map<String, Object> requestData) {
        //TemplateItem createdTemplate = templateItemService.createTemplate(template);
        Long exerciseId = Long.valueOf(requestData.get("exerciseId").toString());
        Long templateId = Long.valueOf(requestData.get("templateId").toString());

        TemplateItem savedTemplateItem = new TemplateItem();

        return new ResponseEntity<>(savedTemplateItem, HttpStatus.CREATED);
    }

    @Operation(summary = "Update template item by Id")
    @PutMapping("/{id}")
    public ResponseEntity<TemplateItem> updateTemplate(@PathVariable long id, @RequestBody TemplateItem template) {
        TemplateItem updatedTemplate = templateItemService.updateTemplate(id, template);
        return new ResponseEntity<>(updatedTemplate, HttpStatus.OK);
    }

    @Operation(summary = "Delete template item by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTemplate(@PathVariable long id) {
        templateItemService.deleteTemplate(id);
        return new ResponseEntity<>("Template successfully deleted!", HttpStatus.OK);
    }
}

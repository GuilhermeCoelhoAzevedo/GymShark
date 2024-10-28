package com.gca.gymShark.Template;

import com.gca.gymShark.TemplateItem.TemplateItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<Template> getAllTemplates(){
        return templateRepository.findAll();
    }

    public Template getTemplate(long id) {
        return templateRepository.findById(id).orElseThrow(TemplateNotFoundException::new);
    }

    public Template createTemplate(Template template) {
        // Set the parent Template reference in each TemplateItem
        if (template.getTemplateItems() != null) {
            for (TemplateItem item : template.getTemplateItems()) {
                item.setTemplate(template);
            }
        }

        return templateRepository.save(template);
    }

    public Template updateTemplate(long id, Template template) {
        // Validate existence of the ID before updating
        if (!templateRepository.existsById(id)) {
            throw new TemplateNotFoundException();
        }

        return templateRepository.save(template);
    }

    public void deleteTemplate(long id) {
        // Validate existence of the ID before deleting
        if (!templateRepository.existsById(id)) {
            throw new TemplateNotFoundException();
        }

        templateRepository.deleteById(id);
    }
}

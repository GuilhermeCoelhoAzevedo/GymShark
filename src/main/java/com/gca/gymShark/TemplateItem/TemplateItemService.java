package com.gca.gymShark.TemplateItem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateItemService {
    private final TemplateItemRepository templateItemRepository;

    public TemplateItemService(TemplateItemRepository templateItemRepository) {
        this.templateItemRepository = templateItemRepository;
    }

    public List<TemplateItem> getAllTemplates(){
        return templateItemRepository.findAll();
    }

    public TemplateItem getTemplate(long id) {
        return templateItemRepository.findById(id).orElseThrow(TemplateItemNotFoundException::new);
    }

    public TemplateItem createTemplate(TemplateItem template) {
        return templateItemRepository.save(template);
    }

    public TemplateItem updateTemplate(long id, TemplateItem template) {
        // Validate existence of the ID before updating
        if (!templateItemRepository.existsById(id)) {
            throw new TemplateItemNotFoundException();
        }

        return templateItemRepository.save(template);
    }

    public void deleteTemplate(long id) {
        // Validate existence of the ID before deleting
        if (!templateItemRepository.existsById(id)) {
            throw new TemplateItemNotFoundException();
        }

        templateItemRepository.deleteById(id);
    }
}

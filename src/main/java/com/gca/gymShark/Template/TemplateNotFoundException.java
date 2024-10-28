package com.gca.gymShark.Template;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Template not found")
public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException() {
        super("Template not found");
    }

    public TemplateNotFoundException(String message) {
        super(message);
    }
}
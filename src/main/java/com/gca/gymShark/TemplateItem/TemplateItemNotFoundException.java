package com.gca.gymShark.TemplateItem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Template not found")
public class TemplateItemNotFoundException extends RuntimeException {
    public TemplateItemNotFoundException() {
        super("Template not found");
    }

    public TemplateItemNotFoundException(String message) {
        super(message);
    }
}
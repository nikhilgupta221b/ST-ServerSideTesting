package com.example.blogs.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, String.valueOf(fieldValue)));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = String.valueOf(fieldValue);
    }

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = String.valueOf(fieldValue);
    }
}

package com.github.CaicoSantos1998.Found.It.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }
}

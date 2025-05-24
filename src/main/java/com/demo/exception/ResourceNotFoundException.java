package com.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String post_not_found) {
        super(post_not_found);
    }


}

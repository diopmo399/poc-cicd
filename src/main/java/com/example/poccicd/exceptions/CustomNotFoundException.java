package com.example.poccicd.exceptions;

public class CustomNotFoundException extends RuntimeException {
        public CustomNotFoundException(String msg) {
            super(msg);
        }
}

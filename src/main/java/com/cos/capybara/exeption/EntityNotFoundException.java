package com.cos.capybara.exeption;

public class EntityNotFoundException extends RuntimeException{

        public EntityNotFoundException(String message) {
            super(message);
        }

        public EntityNotFoundException() {
            super("Entity not found");
        }
}

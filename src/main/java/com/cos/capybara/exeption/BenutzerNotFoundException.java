package com.cos.capybara.exeption;

public class BenutzerNotFoundException extends RuntimeException{

    public BenutzerNotFoundException(String message) {
        super(message);
    }

    public BenutzerNotFoundException() {
        super("User not found");
    }
}

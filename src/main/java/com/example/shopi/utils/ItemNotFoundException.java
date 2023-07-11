package com.example.shopi.utils;

public class ItemNotFoundException extends RuntimeException{

    private final String msg = "The current item is not available";

    @Override
    public String getMessage() {
        return "The current item is not available";
    }
}

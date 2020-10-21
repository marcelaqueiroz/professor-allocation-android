package com.example.professor_allocation;

public interface RequestResult {
    <T> void returnSuccess (T requestResult);
    void returnError (String message);
}

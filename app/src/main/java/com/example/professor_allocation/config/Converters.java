package com.example.professor_allocation.config;

import androidx.room.TypeConverter;

import com.example.professor_allocation.model.Departament;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converters {

    private static ObjectMapper objectMapper;

    @TypeConverter
    public static String listToJson(Departament value) {
        objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{'Error':'Convert error'}";
        }
        // Converter um tipo em uma string
    }

    @TypeConverter
    public static Departament jsonToList(String value) {
        objectMapper = new ObjectMapper();
        Departament arr = new Departament();
        try {
            arr = objectMapper.readValue(value, Departament.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
        //Converter uma string em um tipo
    }
}

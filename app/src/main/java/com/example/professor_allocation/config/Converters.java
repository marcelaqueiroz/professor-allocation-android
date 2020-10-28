package com.example.professor_allocation.config;

import androidx.room.TypeConverter;

import com.example.professor_allocation.model.Allocation;
import com.example.professor_allocation.model.Course;
import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converters {

    private static ObjectMapper objectMapper;

    @TypeConverter
    public static String departamentToList(Departament value) {
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
    public static Departament listToDepartament(String value) {
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


    @TypeConverter
    public static String courseToList(Course value) {
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
    public static Course listToCourse(String value) {
        objectMapper = new ObjectMapper();
        Course arr = new Course();
        try {
            arr = objectMapper.readValue(value, Course.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
        //Converter uma string em um tipo
    }

    @TypeConverter
    public static String allocationToList(Allocation value) {
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
    public static Allocation listToAllocation(String value) {
        objectMapper = new ObjectMapper();
        Allocation arr = new Allocation();
        try {
            arr = objectMapper.readValue(value, Allocation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
        //Converter uma string em um tipo
    }



    @TypeConverter
    public static String professorToList(Professor value) {
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
    public static Professor listToProfessor(String value) {
        objectMapper = new ObjectMapper();
        Professor arr = new Professor();
        try {
            arr = objectMapper.readValue(value, Professor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
        //Converter uma string em um tipo
    }
}

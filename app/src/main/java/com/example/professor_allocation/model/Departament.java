package com.example.professor_allocation.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Department")
public class Departament {
    @PrimaryKey
    private int id;
    private String name;

    public Departament() {
    }

    public Departament(String name) {
        this.name = name;
    }

    public Departament(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

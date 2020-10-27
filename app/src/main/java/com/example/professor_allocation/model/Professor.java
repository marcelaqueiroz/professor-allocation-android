package com.example.professor_allocation.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Professor")
public class Professor {

    @PrimaryKey
    private int id;
    private String name;
    private String cpf;
    private Departament departament;

    public Professor() {
    }

    public Professor(String name, String cpf, Departament departament) {
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}

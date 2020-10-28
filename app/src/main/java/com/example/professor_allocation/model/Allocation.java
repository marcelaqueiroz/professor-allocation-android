package com.example.professor_allocation.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.DayOfWeek;

@Entity(tableName = "Allocation")
public class Allocation {
    @PrimaryKey
    private int id;
    private String dayOfWeek;
    private int startHour;
    private int endHour;
    private Professor professor;
    private Course course;

    public Allocation() {
    }

    public Allocation(String dayOfWeek, int startHour, int endHour, Professor professor, Course course) {
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this.endHour = endHour;
        this.professor = professor;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

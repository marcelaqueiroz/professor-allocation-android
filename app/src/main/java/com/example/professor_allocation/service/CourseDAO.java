package com.example.professor_allocation.service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.professor_allocation.model.Course;

import java.util.List;

@Dao
public interface CourseDAO {

    @Query("SELECT * FROM Course")
    public List<Course> getAllCourses();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertAllCourses(List<Course> courses);
}

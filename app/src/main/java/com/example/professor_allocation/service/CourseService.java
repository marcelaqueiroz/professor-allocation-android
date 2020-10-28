package com.example.professor_allocation.service;

import com.example.professor_allocation.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CourseService {
    @GET("course")
    Call<List<Course>> getAllCourses();

    @GET("course")
    Call<Course> getCourse(@Query("id") int id);

    @DELETE("course")
    Call<Boolean> delete(@Query("id") int id);

    @POST("course")
    Call<Course> createCourse(@Body Course course);
}

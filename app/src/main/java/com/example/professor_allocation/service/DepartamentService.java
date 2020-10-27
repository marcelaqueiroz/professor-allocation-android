package com.example.professor_allocation.service;
import com.example.professor_allocation.model.Departament;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DepartamentService {
    @GET("departament")
    Call<List<Departament>> getAllDepartament();

    @GET("departament")
    Call<Departament> getDepartament(@Query("id") int id);

    @DELETE("departament")
    Call<Boolean> delete(@Query("id") int id);

    @POST("departament")
    Call<Departament> createDepartament(@Body Departament departament);
}

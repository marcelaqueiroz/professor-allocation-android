package com.example.professor_allocation.service;

import com.example.professor_allocation.model.Allocation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AllocationService {

    @GET("allocation")
    Call<List<Allocation>> getAllAllocations();

    @GET("allocation")
    Call<Allocation> getAllocation(@Query("id") int id);

    @DELETE("allocation")
    Call<Boolean> delete(@Query("id") int id);

    @POST("allocation")
    Call<Allocation> createAllocation(@Body Allocation allocation);
}

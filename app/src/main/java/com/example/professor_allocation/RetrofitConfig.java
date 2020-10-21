package com.example.professor_allocation;

import com.example.professor_allocation.service.ProfessorService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    Retrofit retrofit;

    public RetrofitConfig(){
         retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ProfessorService getProfessorService(){
        return retrofit.create(ProfessorService.class);
    }

}

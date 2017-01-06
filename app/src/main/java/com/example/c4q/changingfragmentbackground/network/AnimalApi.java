package com.example.c4q.changingfragmentbackground.network;

import com.example.c4q.changingfragmentbackground.model.AnimalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by C4Q on 1/4/17. http://jsjrobotics.nyc/
 */

public interface AnimalApi {
    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> getAnimalResponse();
}

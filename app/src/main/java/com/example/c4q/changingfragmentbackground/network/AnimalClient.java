package com.example.c4q.changingfragmentbackground.network;

import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C4Q on 1/4/17. http://jsjrobotics.nyc/cgi-bin/12_21_2016_exam.pl
 */

//factory method

public class AnimalClient {

    public static final String BASE_URL = "http://jsjrobotics.nyc/";

    private static Builder httpClient = new Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build())
                .build();

        return retrofit.create(serviceClass);
    }
}

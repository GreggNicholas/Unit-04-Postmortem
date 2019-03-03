package com.example.unit_04_assessment.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit instance;
    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private RetrofitSingleton() {
    }


    public static Retrofit newInstance() {
        if (instance == null) {
            instance = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

}

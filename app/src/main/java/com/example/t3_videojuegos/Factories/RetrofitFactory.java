package com.example.t3_videojuegos.Factories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    public static Retrofit build() {

        return new Retrofit.Builder()
                .baseUrl("https://628f5f07dc478523653f54ef.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

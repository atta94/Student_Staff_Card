package com.example.student_staff_card;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static String BASE_URL = "http://192.168.137.1:8080/api/";
    private static Retrofit retrofit;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder ()
                    .baseUrl ( BASE_URL )
                    .addConverterFactory ( GsonConverterFactory.create () )
                    .build ();
        }
        return retrofit;


    }
}


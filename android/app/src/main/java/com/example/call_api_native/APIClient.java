package com.example.call_api_native;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {
    private static Retrofit retrofit = null;
    private static final String domain = "https://apiv2.dev.icheck.vn";

    private static Interceptor createInterceptor() {
        return chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", "Bearer 0e81f213-2631-48f9-ae97-0fe0cbd295fb")
                    .header("Content-Type", "application/json");

            Request request = requestBuilder.build();
            return chain.proceed(request);
        };
    }

    private static OkHttpClient createClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(createInterceptor()).build();
    }

    static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(domain)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(createClient())
                    .build();
            return retrofit;
        }
        return retrofit;
    }
}
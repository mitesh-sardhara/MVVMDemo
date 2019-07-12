package com.example.demo.data.remote;

import com.example.demo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCallFactory {

    private static final int NETWORK_CALL_TIMEOUT = 600;

    public static ApiHelper create() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);
        builder.followRedirects(false);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(ApiHelper.class);
    }
}

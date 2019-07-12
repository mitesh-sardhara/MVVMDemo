package com.example.demo.data.remote;

import com.example.demo.pojo.PojoUsers;
import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiHelper {

    @POST("getUsers")
    Observable<PojoUsers> getUserList(@Body Map<String, Object> params);

}

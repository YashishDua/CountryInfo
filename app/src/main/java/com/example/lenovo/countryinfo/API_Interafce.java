package com.example.lenovo.countryinfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Lenovo on 10-07-2016.
 */
public interface API_Interafce {
    @GET("/name/{name}")
    Call<ArrayList<ContentResponse>> getdetails(@Path("name") String name);

    @GET("/alpha/{code}")
    Call<ContentResponse> getdetails_via_code(@Path("code") String code);

    @GET("/lang/{et}")
    Call<ArrayList<ContentResponse>> getdetails_via_language(@Path("et") String et);

    @GET("/currency/{currency}")
    Call<ArrayList<ContentResponse>> getdetails_via_currency(@Path("currency") String currency);

    @GET("/region/{region}")
    Call<ArrayList<ContentResponse>> getdetails_via_region(@Path("region") String region);

}

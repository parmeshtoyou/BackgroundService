package com.example.backgroundservice.api;

import com.example.backgroundservice.model.ResponseModel;
import com.example.backgroundservice.model.SecondResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ServiceInterface {

    @GET
    Call<ResponseModel> callFirstApi(@Url String url);

    @GET
    Call<SecondResponseModel> callSecondApi(@Url String url);

}

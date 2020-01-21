package com.example.retorofit.data.internet;

import com.example.retorofit.data.entity.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("data/2.5/weather")
    Call<CurrentWeather> fetchtCurrentWeather(@Query("q") String city,
                                              @Query("appid") String appId,
                                              @Query("units") String units);
}

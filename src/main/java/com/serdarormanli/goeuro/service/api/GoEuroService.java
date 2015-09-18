package com.serdarormanli.goeuro.service.api;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import com.serdarormanli.goeuro.model.City;

/***
 * Retrofit interface to position api
 * 
 * @author ormanli
 *
 */
public interface GoEuroService {
	@GET("/api/v2/position/suggest/en/{cityName}")
	Call<List<City>> listCity(@Path("cityName") String cityName);
}

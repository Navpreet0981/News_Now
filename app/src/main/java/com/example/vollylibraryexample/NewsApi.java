package com.example.vollylibraryexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/top-headlines")
    Call<DataModelClass.Root> getTopHeadlines
            (@Query("country") String country,
             @Query("category") String category,
             @Query("apiKey") String apiKey);
}

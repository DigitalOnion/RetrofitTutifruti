package com.outerspace.retrofittutifruti.api.signature;

import com.outerspace.retrofittutifruti.api.Pixabay;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    public static final String BASE_URL = "https://pixabay.com/";
    public static final String END_POINT = "api";

    public static final String API_KEY = "8782397-0167754e846f520e8c572b2ab";

    @GET(END_POINT)
    Call<Pixabay>  requestPixabay(
            @Query("q") String query,
            @Query("key") String api_key
    );

    @GET(END_POINT)
    Single<Pixabay> requestRxPixabay (
            @Query("q") String query,
            @Query("key") String api_key
    );

}

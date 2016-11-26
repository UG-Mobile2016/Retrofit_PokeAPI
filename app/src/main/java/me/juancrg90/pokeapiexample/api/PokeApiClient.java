package me.juancrg90.pokeapiexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public class PokeApiClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "http://pokeapi.co/";

    public PokeApiClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public PokeApiService getPokeApiService() {
        return this.retrofit.create(PokeApiService.class);
    }
}

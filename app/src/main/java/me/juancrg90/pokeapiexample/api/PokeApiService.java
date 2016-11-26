package me.juancrg90.pokeapiexample.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public interface PokeApiService {

    @GET("api/v2/{endpoint}")
    Call<PokemonResponse> ListPokemons(@Path("endpoint") String endPoint);

}

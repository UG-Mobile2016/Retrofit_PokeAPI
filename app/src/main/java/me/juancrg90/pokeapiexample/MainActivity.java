package me.juancrg90.pokeapiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import me.juancrg90.pokeapiexample.api.PokeApiClient;
import me.juancrg90.pokeapiexample.api.PokeApiService;
import me.juancrg90.pokeapiexample.api.PokemonResponse;
import me.juancrg90.pokeapiexample.entities.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PokeApiService pokeApiService;
    PokeApiClient pokeApiClient = new PokeApiClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokeApiService = pokeApiClient.getPokeApiService();


        Call<PokemonResponse> call = pokeApiService.ListPokemons("pokemon");

        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                int count = response.body().getCount();
                List<Pokemon> pokemons = response.body().getResults();
                Log.v("Count", Integer.toString(count));

                for(int i = 0; i < pokemons.size(); i++) {
                    Log.v("Pokemon-URL", pokemons.get(i).getUrl());
                    Log.v("Pokemon-Name", pokemons.get(i).getName());
                }

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("ERROR", "Someting went wrong: " + t.getMessage());

            }
        });
    }
}

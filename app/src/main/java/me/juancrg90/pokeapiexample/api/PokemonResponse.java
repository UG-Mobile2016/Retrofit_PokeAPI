package me.juancrg90.pokeapiexample.api;

import java.util.List;

import me.juancrg90.pokeapiexample.entities.Pokemon;

/**
 * Created by JuanCrg90 on 11/26/16.
 */
public class PokemonResponse {
    private int count;
    private List<Pokemon> result;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Pokemon> getResult() {
        return result;
    }

    public void setResult(List<Pokemon> result) {
        this.result = result;
    }
}

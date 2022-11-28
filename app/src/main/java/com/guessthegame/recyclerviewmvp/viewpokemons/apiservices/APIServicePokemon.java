package com.guessthegame.recyclerviewmvp.viewpokemons.apiservices;

import com.guessthegame.recyclerviewmvp.viewpokemons.model.PokemonResponseLoad;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServicePokemon {
    @GET("pokemon")
    Call<PokemonResponseLoad> loadPokemon();
}

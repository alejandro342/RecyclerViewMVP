package com.guessthegame.recyclerviewmvp.services;


import com.guessthegame.recyclerviewmvp.viewpokemons.apiservices.APIServicePokemon;

public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static APIServicePokemon getAPIServiceViewPokemon() {
        return WebServicesAPI.getClient(BASE_URL).create(APIServicePokemon.class);
    }

}

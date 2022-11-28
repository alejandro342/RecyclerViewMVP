package com.guessthegame.recyclerviewmvp.viewpokemons.interfaces;



import com.guessthegame.recyclerviewmvp.viewpokemons.model.Pokemon;

import java.util.ArrayList;

public interface InterfacePresenter {
    void addPokemon(ArrayList<Pokemon> mPokemons);

    void showProgressBar();

    void hideProgressBar();
}
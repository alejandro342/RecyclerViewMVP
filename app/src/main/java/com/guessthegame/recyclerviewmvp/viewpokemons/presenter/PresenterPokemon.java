package com.guessthegame.recyclerviewmvp.viewpokemons.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.guessthegame.recyclerviewmvp.network.NetworkUtils;
import com.guessthegame.recyclerviewmvp.services.ApiUtils;
import com.guessthegame.recyclerviewmvp.viewpokemons.apiservices.APIServicePokemon;
import com.guessthegame.recyclerviewmvp.viewpokemons.interfaces.InterfacePresenter;
import com.guessthegame.recyclerviewmvp.viewpokemons.model.Pokemon;
import com.guessthegame.recyclerviewmvp.viewpokemons.model.PokemonResponseLoad;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterPokemon implements InterfacePresenter {

    private final InterfacePresenter mView;
    private final Context mContext;
    ArrayList<Pokemon> mArrayListPokemon = new ArrayList<>();

    public PresenterPokemon(InterfacePresenter mInterfacePresenter, Context mContext) {
        this.mView = mInterfacePresenter;
        this.mContext = mContext;

    }

    public void dataPokemon() {
        APIServicePokemon readpokemon = ApiUtils.getAPIServiceViewPokemon();
        Call<PokemonResponseLoad> call = readpokemon.loadPokemon();

        if (NetworkUtils.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            call.enqueue(new Callback<PokemonResponseLoad>() {
                @Override
                public void onResponse(@NonNull Call<PokemonResponseLoad> call, @NonNull Response<PokemonResponseLoad> response) {
                    if (response.isSuccessful()) {
                        PokemonResponseLoad pokemonResponse = response.body();
                        assert pokemonResponse != null;
                        mArrayListPokemon = pokemonResponse.getResults();
                        mView.addPokemon(mArrayListPokemon);
                        assert response.body() != null;
                    } else {
                        Toast.makeText(mContext, "" + response.errorBody(), Toast.LENGTH_SHORT).show();
                    }
                    mView.hideProgressBar();
                }

                @Override
                public void onFailure(@NonNull Call<PokemonResponseLoad> call, @NonNull Throwable t) {
                    Toast.makeText(mContext, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(mContext, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void addPokemon(ArrayList<Pokemon> mPokemons) {
    }

    @Override
    public void showProgressBar() {
    }

    @Override
    public void hideProgressBar() {
    }
}

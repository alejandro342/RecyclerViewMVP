package com.guessthegame.recyclerviewmvp.viewpokemons.views.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.guessthegame.recyclerviewmvp.databinding.ActivityPokemonViewBinding;
import com.guessthegame.recyclerviewmvp.viewpokemons.interfaces.InterfacePresenter;
import com.guessthegame.recyclerviewmvp.viewpokemons.model.Pokemon;
import com.guessthegame.recyclerviewmvp.viewpokemons.presenter.PresenterPokemon;
import com.guessthegame.recyclerviewmvp.viewpokemons.views.adapters.AdapterPokemonView;

import java.util.ArrayList;


public class PokemonView extends AppCompatActivity implements InterfacePresenter {

    AdapterPokemonView mAdapterPokemonView;
    PresenterPokemon mPresenterPokemon;
    private ActivityPokemonViewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityPokemonViewBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        mAdapterPokemonView = new AdapterPokemonView();
        mBinding.pokemonViewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.pokemonViewRecyclerView.setHasFixedSize(true);
        mBinding.pokemonViewRecyclerView.setAdapter(mAdapterPokemonView);

        mPresenterPokemon = new PresenterPokemon(this, this);
        mPresenterPokemon.dataPokemon();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void addPokemon(ArrayList<Pokemon> mPokemons) {
        mAdapterPokemonView.submitList(mPokemons);
        mAdapterPokemonView.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        mBinding.progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mBinding.progressView.setVisibility(View.GONE);
    }
}
//package com.guessthegame.pokemonapi.viewpokemons.views.adapters;
package com.guessthegame.recyclerviewmvp.viewpokemons.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.guessthegame.recyclerviewmvp.R;
import com.guessthegame.recyclerviewmvp.viewpokemons.model.Pokemon;
import com.squareup.picasso.Picasso;

public class AdapterPokemonView extends ListAdapter<Pokemon, AdapterPokemonView.ViewHolderPokemon> {

    public AdapterPokemonView() {
        super(mCallback);
    }

    private static final DiffUtil.ItemCallback<Pokemon> mCallback = new DiffUtil.ItemCallback<Pokemon>() {
        @Override
        public boolean areItemsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Pokemon oldItem, @NonNull Pokemon newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };

    @NonNull
    @Override
    public ViewHolderPokemon onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolderPokemon(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPokemon holder, int position) {
        holder.nombreTextView.setText(getItem(position).getName());

        Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                        + getItem(position).getNumber() + ".png")
                .into(holder.fotoImageView);
    }

    public static class ViewHolderPokemon extends RecyclerView.ViewHolder {

        private final ImageView fotoImageView;
        private final TextView nombreTextView;

        public ViewHolderPokemon(View itemView) {
            super(itemView);

            fotoImageView = itemView.findViewById(R.id.imgViewUser);
            nombreTextView = itemView.findViewById(R.id.txtNameUser);
        }
    }
}

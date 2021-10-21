package com.devcristine.pokedex.ui.pokemonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devcristine.pokedex.R
import com.devcristine.pokedex.modelApi.Result
import kotlinx.android.synthetic.main.activity_pokemon_info.*

import kotlinx.android.synthetic.main.activity_pokemon_info.view.*
import kotlinx.android.synthetic.main.card_pokemon_search.view.*


/**
 * Created by Cristine R.M. on 21/10/2021.
 * DevCristineAguirre
 */
class PokeListAdapter (val  pokemonClick: (Int) -> Unit) : RecyclerView.Adapter<PokeListAdapter.SearchViewHolder> (){
    var pokemonList: List<Result> = emptyList<Result>()

    fun setData(list: List<Result>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon_search, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }


    }


    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}
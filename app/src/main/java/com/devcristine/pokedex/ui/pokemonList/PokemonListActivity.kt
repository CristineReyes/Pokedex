package com.devcristine.pokedex.ui.pokemonList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.devcristine.pokedex.R
import com.devcristine.pokedex.ui.pokemonInfo.PokemonInfoActivity
import kotlinx.android.synthetic.main.activity_pokemon_info.*
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import java.util.*


class PokemonListActivity : AppCompatActivity() {

    private lateinit var viewModel: PokeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        // inicializar vm
        viewModel=ViewModelProvider(this).get(PokeListViewModel::class.java)


        initUI()
    }



    private fun initUI(){
        pokeListReciclerView.layoutManager = LinearLayoutManager(this)
        pokeListReciclerView.adapter = PokeListAdapter{
            val intent = Intent(this, PokemonInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        /// solicitar lista
        viewModel.getPokemonList()


        // obser ar cambios en la lista

        viewModel.pokemonList.observe(this, Observer { list ->

            (pokeListReciclerView.adapter as PokeListAdapter).setData(list)
        })

    }




}
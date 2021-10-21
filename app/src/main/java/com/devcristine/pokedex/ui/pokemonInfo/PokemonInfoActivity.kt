package com.devcristine.pokedex.ui.pokemonInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import androidx.lifecycle.Observer

import com.devcristine.pokedex.R
import kotlinx.android.synthetic.main.activity_pokemon_info.*
import kotlinx.android.synthetic.main.card_pokemon_search.*
import java.util.*

class PokemonInfoActivity : AppCompatActivity() {
    // declara ViewModel
    lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)


        // iniciañlizar VM
        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)

        initUI()

    }

    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        // obtener info
        viewModel.getPokemonInfo(id)

        // escuchar cambios en la info
        viewModel.pokemonInfo.observe(this, Observer { pokemon  ->
            tvName.text = pokemon.name
            speciesText.text= "Especie ${pokemon.species.name}"
            heightText.text= "Altura: ${pokemon.height/10.0}" /// podemos jugar con los valores
            weightText.text= "Peso: ${pokemon.weight/10.0}"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(imageView)
        })


    }
}
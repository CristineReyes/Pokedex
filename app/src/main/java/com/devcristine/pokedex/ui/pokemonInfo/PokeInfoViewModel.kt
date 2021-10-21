package com.devcristine.pokedex.ui.pokemonInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcristine.pokedex.modelApi.Pokemons
import com.devcristine.pokedex.services.ApiServicesPokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Cristine R.M. on 21/10/2021.
 * DevCristineAguirre
 */
class PokeInfoViewModel(): ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ApiServicesPokemon = retrofit.create(ApiServicesPokemon::class.java)

    val pokemonInfo = MutableLiveData<Pokemons>()


    fun getPokemonInfo(id: Int){
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<Pokemons>{
            override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
                response.body()?.let { pokemons ->
                    pokemonInfo.postValue(pokemons)
                }
            }

            override fun onFailure(call: Call<Pokemons>, t: Throwable) {
               call.cancel()
            }

        })




    }

}
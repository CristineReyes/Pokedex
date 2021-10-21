package com.devcristine.pokedex.ui.pokemonList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcristine.pokedex.modelApi.ApiResponsePokemon
import com.devcristine.pokedex.modelApi.Result
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
class PokeListViewModel() : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ApiServicesPokemon = retrofit.create(ApiServicesPokemon::class.java)

    val pokemonList = MutableLiveData<List<Result>>()


    fun getPokemonList(){
        val call  = service.getPokemonList(100,0) // limite

        call.enqueue(object : Callback<ApiResponsePokemon>{
            override fun onResponse(
                call: Call<ApiResponsePokemon>,
                response: Response<ApiResponsePokemon>
            ) {
                response.body()?.results?.let {
                    list ->
                    pokemonList.postValue(list) // entran datos y avisa a observable que hay cambios
                }
            }

            override fun onFailure(call: Call<ApiResponsePokemon>, t: Throwable) {
                call.cancel()
            }


        })
    }


}
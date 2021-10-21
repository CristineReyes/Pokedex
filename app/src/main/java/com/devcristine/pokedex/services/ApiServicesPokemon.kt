package com.devcristine.pokedex.services

import com.devcristine.pokedex.modelApi.ApiResponsePokemon
import com.devcristine.pokedex.modelApi.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Cristine R.M. on 20/10/2021.
 * DevCristineAguirre
 */
interface ApiServicesPokemon {


    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path ("id") id:Int): Call<Pokemons>

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<ApiResponsePokemon>


}
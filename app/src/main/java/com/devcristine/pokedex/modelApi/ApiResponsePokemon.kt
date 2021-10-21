package com.devcristine.pokedex.modelApi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
  * Created by Cristine R.M. on 21/10/2021.
   * DevCristineAguirre
*/
data class ApiResponsePokemon (
    @Expose @SerializedName("count") val count: Int,
    @Expose @SerializedName("next") val next: String,
    @Expose @SerializedName("previous") val previous: String,
    @Expose @SerializedName("results") val results: List<Result>
)

data class Result (
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String
)
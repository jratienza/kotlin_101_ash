package ph.apper.android.atienza.api.api

import ph.apper.android.atienza.api.model.PokemonInfoResponse
import ph.apper.android.atienza.api.model.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon/")
    fun getList(
        @Query("offset") startIndex:Int,
        @Query("limit") limit:Int)
            : Call<PokemonListResponse>

    @GET("pokemon/{pokemonId}/")
    fun getPokemonInfo(
        @Path("pokemonId") pokemonID:Int)
            : Call<PokemonInfoResponse>



}
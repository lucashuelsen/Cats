package br.com.cats.data.remote

import br.com.cats.data.model.CatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatService {

    @GET("3/gallery/search")
    fun searchImages(
        @Header("Authorization") authorization: String,
        @Query("q") query: String
    ): Call<CatResponse>
}
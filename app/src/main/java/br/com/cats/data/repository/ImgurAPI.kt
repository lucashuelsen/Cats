package br.com.cats.data.repository

import br.com.cats.data.model.CatsGallery
import br.com.cats.data.remote.CatService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ImgurAPI {
    companion object {
        const val URL = "https://api.imgur.com/"
        val CLIENTE_ID = "1ceddedc03a5d71"
        val AUTHORIZATION_HEADER = "Client-ID $CLIENTE_ID"
    }

    fun getCats(query: String = "cats"): List<CatsGallery> {
        return try {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val catService = retrofit.create(CatService::class.java)

            val response = catService.searchImages(AUTHORIZATION_HEADER, query).execute()
            val galleryItems = if (response.isSuccessful) {
                val galleryResponse = response.body()
                galleryResponse?.data
            } else {
                emptyList()
            }

            return galleryItems?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}


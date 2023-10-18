package br.com.cats.repository

import br.com.cats.model.CatResponse
import br.com.cats.model.CatsGallery
import br.com.cats.services.CatService
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

public class ImgurAPI {
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

            //TODO: REMOVER FILTRO E TRATAR PARA EXIBIR GIFS NO RECYCLERVIEW
            return galleryItems?.filter {
                it.images.count { it.type == "image/jpeg" } > 0
            }?: emptyList()
        } catch (e: Exception) {
            // Trate outras exceções, se necessário
            emptyList()
        }
    }
}


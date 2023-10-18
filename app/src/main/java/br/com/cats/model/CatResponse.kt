package br.com.cats.model

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("data")
    val data: List<CatsGallery>
) {

}
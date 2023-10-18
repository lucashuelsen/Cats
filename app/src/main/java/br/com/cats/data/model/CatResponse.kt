package br.com.cats.data.model

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("data")
    val data: List<CatsGallery>
) {

}
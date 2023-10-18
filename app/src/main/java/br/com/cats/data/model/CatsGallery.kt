package br.com.cats.data.model

import com.google.gson.annotations.SerializedName

data class CatsGallery(
    @SerializedName("id")
    var id: String = "",

    @SerializedName("link")
    var link: String = "",

    @SerializedName("title")
    var title: String = "",

    @SerializedName("images")
    var images: List<Cats>
) {

    fun getFirstImage(): String{
        return images.first().link?: this.link
    }
}
package br.com.cats.data.model

import com.google.gson.annotations.SerializedName

data class Cats (
    @SerializedName("id")
    var id: String = "",

    @SerializedName("link")
    var link: String = "",

    @SerializedName("type")
    var type: String = "",

    @SerializedName("gifv")
    var gifv: String = ""
){

}
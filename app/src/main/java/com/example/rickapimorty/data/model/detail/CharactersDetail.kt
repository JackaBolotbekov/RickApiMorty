package com.example.rickapimorty.data.model.detail

import com.google.gson.annotations.SerializedName

data class CharactersDetail(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("status")
    val status: String = "",
    @SerializedName("species")
    val species: String = ""
)
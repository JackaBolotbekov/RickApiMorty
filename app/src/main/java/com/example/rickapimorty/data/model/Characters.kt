package com.example.rickapimorty.data.model

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int = 0,
)
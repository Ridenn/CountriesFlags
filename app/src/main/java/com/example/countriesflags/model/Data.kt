package com.example.countriesflags.model

import com.google.gson.annotations.SerializedName

data class Country(
    //TODO - '@SerializedName' mapeia a variável no JSON
    @SerializedName("name")
    val countryName: String?,

    @SerializedName("capital")
    val capital: String?,

    @SerializedName("flagPNG")
    val flag: String?
)
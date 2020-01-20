package com.example.countriesflags.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesApi {

    @GET("Ridenn/Countries/master/countriesV2.json")
    fun getCountries() : Single<List<Country>>

}
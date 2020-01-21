package com.example.countriesflags.model

import com.example.countriesflags.dependencyinjection.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesApi

    //TODO - Inicializar variáveis, porém com injeção de dependencias do Dagger
    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries() : Single<List<Country>>{
        return api.getCountries()
    }
}
package com.example.countriesflags.dependencyinjection

import com.example.countriesflags.model.CountriesService
import com.example.countriesflags.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)
}
package com.example.countriesflags.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countriesflags.R
import com.example.countriesflags.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        //TODO - 'countriesList' é a RecyclerView do layout 'activity_main'
        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        //TODO - vai carregar a lista de países na tela
        observeViewModel()
    }

    fun observeViewModel(){
        //TODO - observa o 'countries, caso não seja nulo, dá update na lista de países
        viewModel.countries.observe(this, Observer { countries ->
            //TODO - ?.let verifica se o 'countries' não é null
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it) }
        })

        //TODO - observa o 'countryLoadError, se possuir erro no carregamento da lista, exibe a mensagem de erro
        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE}
        })

        //TODO - observa o 'loading, se estiver carregando, exibe o loading bar e faz o resto desaparecer
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it){
                    list_error.visibility = View.GONE
                    countriesList.visibility = View.GONE
                }
            }
        })
    }
}

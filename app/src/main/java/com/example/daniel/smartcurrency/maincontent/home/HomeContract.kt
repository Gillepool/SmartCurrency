package com.example.daniel.smartcurrency.maincontent.home

import com.example.daniel.smartcurrency.models.Currency
import com.example.daniel.smartcurrency.responsemodels.Envelope
import io.reactivex.Single

class HomeContract {
    interface View {
        fun showError()
        fun showRates(currencies: List<Currency>)
    }

    interface Presenter{
        fun attachView(view: View)
        fun getRates()
        fun detach()
    }

    interface Model{
        fun getCurrency(): Single<List<Currency>>
    }
}
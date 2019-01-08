package com.example.daniel.smartcurrency.network

import android.util.Log
import com.example.daniel.smartcurrency.maincontent.home.HomeRepository
import com.example.daniel.smartcurrency.responsemodels.Envelope
import io.reactivex.Single
import javax.inject.Inject

class NetworkRepository @Inject constructor(var currencyApi: CurrencyApi): HomeRepository.Network{

    override fun getResponse(): Single<Envelope> {
        currencyApi.getData().map{ Log.d("envelope", "hello again")}
        return currencyApi.getData()
    }
}
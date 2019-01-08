package com.example.daniel.smartcurrency.network

import com.example.daniel.smartcurrency.responsemodels.Envelope
import io.reactivex.Single
import retrofit2.http.GET

interface CurrencyApi {

    @GET("eurofxref-daily.xml")
    fun getData(): Single<Envelope>
}
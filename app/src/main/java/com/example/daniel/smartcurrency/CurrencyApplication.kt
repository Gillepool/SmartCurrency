package com.example.daniel.smartcurrency

import android.app.Application
import timber.log.Timber

class CurrencyApplication: Application() {

    companion object {
        lateinit var currencyApplicationComponent: CurrencyApplicationComponent
    }

    override fun onCreate() {

        super.onCreate()
        currencyApplicationComponent = DaggerCurrencyApplicationComponent.builder()
            .currencyApplicationModule(CurrencyApplicationModule(this))
            .build()
        Timber.plant(Timber.DebugTree())

    }
}
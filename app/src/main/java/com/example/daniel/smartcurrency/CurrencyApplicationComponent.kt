package com.example.daniel.smartcurrency

import com.example.daniel.smartcurrency.MainActivity
import com.example.daniel.smartcurrency.utils.NetworkUtilModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkUtilModule::class, CurrencyApplicationModule::class])
interface CurrencyApplicationComponent {
    fun inject(mainActivity: MainActivity)
}
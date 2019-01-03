package com.example.daniel.smartcurrency

import com.example.daniel.smartcurrency.maincontent.MainActivity
import com.example.daniel.smartcurrency.maincontent.home.HomeFragment
import com.example.daniel.smartcurrency.utils.NetworkUtilModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkUtilModule::class, CurrencyApplicationModule::class])
interface CurrencyApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(homeFragment: HomeFragment)
}
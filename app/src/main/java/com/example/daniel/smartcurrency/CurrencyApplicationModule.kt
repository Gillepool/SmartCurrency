package com.example.daniel.smartcurrency

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CurrencyApplicationModule (private val application: Application){

    @Provides
    @Singleton
    fun provideContext(): Context{
        return application
    }

}
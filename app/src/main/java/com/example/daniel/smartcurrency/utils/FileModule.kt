package com.example.daniel.smartcurrency.utils

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class FileModule {

    @Provides
    fun providesContext(context: Context): Context{
        return context
    }
}
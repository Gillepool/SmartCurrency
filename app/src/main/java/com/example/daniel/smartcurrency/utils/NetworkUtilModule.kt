package com.example.daniel.smartcurrency.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.Module
import dagger.Provides

@Module
class NetworkUtilModule {
    @Provides
    fun getNetworkInfo(c: Context): NetworkInfo{
        var connectivityManager: ConnectivityManager = c.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo
    }
}
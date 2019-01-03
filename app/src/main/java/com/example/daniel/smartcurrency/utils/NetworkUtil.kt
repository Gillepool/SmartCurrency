package com.example.daniel.smartcurrency.utils

import android.net.ConnectivityManager
import android.net.NetworkInfo
import javax.inject.Inject

class NetworkUtil @Inject constructor(var networkInfo: NetworkInfo){

    fun haveConnection(): Boolean{
        return networkInfo.isConnected
    }

    fun haveWifiConnection(): Boolean{
        return true
    }

}
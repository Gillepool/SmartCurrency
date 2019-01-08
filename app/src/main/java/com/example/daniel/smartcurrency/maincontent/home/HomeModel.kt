package com.example.daniel.smartcurrency.maincontent.home

import android.util.Log
import com.example.daniel.smartcurrency.models.Currency
import com.example.daniel.smartcurrency.network.NetworkRepository
import com.example.daniel.smartcurrency.responsemodels.Envelope
import com.example.daniel.smartcurrency.utils.FileRepository
import com.example.daniel.smartcurrency.utils.NetworkUtil
import io.reactivex.Single

class HomeModel constructor(private var networkRepository: NetworkRepository,
                            private var fileRepository: FileRepository,
                            private var networkUtil: NetworkUtil) : HomeContract.Model{

    override fun getCurrency(): Single<List<Currency>> {
        if (networkUtil.haveConnection()) {
            Log.d("envelope1", "have connection")
            val envelopeSingle = networkRepository.getResponse().map {
                    t: Envelope ->
                Log.d("envelope1", "test")
                fileRepository.saveToFile(t)
            }
            Log.d("envelope1", "$envelopeSingle")

        }
//        val envelope: Envelope = fileRepository.readFromFile()

        return  networkRepository.getResponse().map { t: Envelope -> t.getCube().getTimeCube().getCubes().map {
            Currency(it.getCurrency(), it.getRate())
        } }

       /* if (!networkUtil.haveConnection()) {

        } else {
           // val downloadedTime = envelope.getTimestamp()
            //val timeNow = System.currentTimeMillis()
            if (networkUtil.haveWifiConnection()) {
              //  if (timeNow / (1000 * 60) - downloadedTime / (1000 * 60) > 10) {
                    networkRepository.getResponse()
               // }
            } else if (networkUtil.haveWifiConnection()) {
              //  if (timeNow / (1000 * 60) - downloadedTime / (1000 * 60) > 60) {

               // }
            }
        }


        
        return networkRepository.getResponse()*/
    }

}
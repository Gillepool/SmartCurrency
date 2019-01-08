package com.example.daniel.smartcurrency.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Scheduler @Inject constructor(){

    fun getWorker(): Scheduler {
        return Schedulers.io()
    }

    fun getMainThread(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }


}
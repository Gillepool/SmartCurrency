package com.example.daniel.smartcurrency.maincontent.home

import android.util.Log
import com.example.daniel.smartcurrency.network.NetworkRepository
import com.example.daniel.smartcurrency.utils.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter @Inject constructor(var networkRepository: HomeRepository.Network,
                                        var scheduler: Scheduler,
                                        var model: HomeContract.Model): HomeContract.Presenter{
    override fun detach() {
        disposables.clear()
    }

    private lateinit var mView: HomeContract.View
    private val disposables = CompositeDisposable()


    override fun attachView(view: HomeContract.View) {
        this.mView = view
    }

    override fun getRates() {
        var currenciesObservable = model.getCurrency()
        disposables.add(
            currenciesObservable
                .subscribeOn(scheduler.getWorker())
                .observeOn(scheduler.getMainThread())
                .subscribe({ it ->
                    Log.d("homeresponse", "$it")
                    this.mView.showRates(it)
                }, {
                    t ->
                    Log.d("homeresponse", "${t.message} ${t.cause.toString()} ${t.localizedMessage} ${t.printStackTrace()}")
                    this.mView.showError()
                })
        )
    }


}
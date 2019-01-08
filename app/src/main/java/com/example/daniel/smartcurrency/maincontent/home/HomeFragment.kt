package com.example.daniel.smartcurrency.maincontent.home

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daniel.smartcurrency.CurrencyApplication
import com.example.daniel.smartcurrency.R
import com.example.daniel.smartcurrency.models.Currency
import com.example.daniel.smartcurrency.responsemodels.Envelope
import javax.inject.Inject


class HomeFragment: Fragment(), HomeContract.View {

    @Inject
    lateinit var homePresenter: HomePresenter
    override fun showError() {

    }

    override fun showRates(currencies: List<Currency>) {

    }

    companion object {
        fun newInstance(): HomeFragment {
            val offersFragment = HomeFragment()
            val args = Bundle()
            offersFragment.arguments = args
            return offersFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CurrencyApplication.currencyApplicationComponent.inject(this)


        initVariables()
        homePresenter.attachView(this)
        homePresenter.getRates()
    }

    override fun onDestroy() {
        homePresenter.detach()
        super.onDestroy()
    }

    private fun initVariables() {

    }

}
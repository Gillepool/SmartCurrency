package com.example.daniel.smartcurrency.maincontent.home

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daniel.smartcurrency.CurrencyApplication
import com.example.daniel.smartcurrency.R
import com.example.daniel.smartcurrency.models.Currency
import com.example.daniel.smartcurrency.responsemodels.Envelope
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_recyclerview_item.*
import javax.inject.Inject


class HomeFragment: Fragment(), HomeContract.View {

    @Inject
    lateinit var homePresenter: HomePresenter
    private lateinit var recyclerViewCurrencies: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var currencies: ArrayList<Currency>


    override fun showError() {

    }

    override fun showRates(currencies: List<Currency>) {
        this.currencies = ArrayList(currencies)
        adapter.setCurrenciesAndUpdate(this.currencies)
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
        initAdapter()
    }

    override fun onDestroy() {
        homePresenter.detach()
        super.onDestroy()
    }

    private fun initAdapter() {
        adapter = HomeAdapter(currencies) { currency ->
            Log.d("click","clicked currency")
        }
        recyclerViewCurrencies.adapter = adapter
    }

    private fun initVariables() {
        recyclerViewCurrencies = list
        val layoutManager = LinearLayoutManager(context)
        recyclerViewCurrencies.layoutManager =layoutManager
        this.currencies = ArrayList()


    }

}
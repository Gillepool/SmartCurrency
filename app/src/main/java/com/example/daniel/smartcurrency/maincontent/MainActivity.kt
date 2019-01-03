package com.example.daniel.smartcurrency.maincontent

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.daniel.smartcurrency.CurrencyApplication
import com.example.daniel.smartcurrency.R
import com.example.daniel.smartcurrency.maincontent.home.HomeFragment


inline fun android.support.v4.app.FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, name: String) {
    supportFragmentManager.inTransaction { add(frameId, fragment, name).addToBackStack(null) }
}

fun AppCompatActivity.showFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { show(fragment) }
}

fun AppCompatActivity.hideFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { hide(fragment) }
}

class MainActivity : AppCompatActivity() {

    private var intentFragment: Int = 0

    companion object {
        fun startActivity(context: Context, startFragment: Int): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private val homeFragment: HomeFragment by lazy {
        HomeFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CurrencyApplication.currencyApplicationComponent.inject(this)

        addFragment(homeFragment, R.id.content, "homeFragment")
    }
}

package com.example.daniel.smartcurrency.responsemodels

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "Cube/Cube")
class CurrencyCube {

    @field:Attribute(name = "currency")
    private lateinit var currency: String
    @field:Attribute(name = "rate")
    private lateinit var rate: String

    fun getCurrency(): String {
        return currency
    }

    fun getRate(): String{
        return this.rate
    }




}
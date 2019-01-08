package com.example.daniel.smartcurrency.responsemodels

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="Cube")
class TimeCube {

    @field:Attribute(name="time")
    private lateinit var time:String
    @field:ElementList(entry = "Cube", inline = true)
    private lateinit var Cubes: Collection<CurrencyCube>

    fun getCubes(): Collection<CurrencyCube> {
        return this.Cubes
    }



}
package com.example.daniel.smartcurrency.responsemodels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name="Cube")
class Cube {
    @field:Element(name="Cube") private lateinit var timeCube: TimeCube

    fun getTimeCube(): TimeCube{
        return this.timeCube
    }
}
package com.example.daniel.smartcurrency.responsemodels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Envelope")
class Envelope {

    @field:Element(name="subject") private lateinit var subject: String
    @field:Element(name="Sender") private lateinit var sender: Sender
    @field:Element(name="Cube") private lateinit var cube: Cube
    private var timestamp: Long = 0

    fun getCube(): Cube {
        return this.cube
    }

    fun setTimestamp(timestamp: Long){
        this.timestamp = timestamp
    }

    fun getTimestamp(): Long {
        return this.timestamp
    }
}
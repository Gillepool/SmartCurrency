package com.example.daniel.smartcurrency.responsemodels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Sender")
class Sender {
    @field:Element(name="name") private lateinit var name: String
}
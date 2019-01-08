package com.example.daniel.smartcurrency.maincontent.home

import com.example.daniel.smartcurrency.responsemodels.Envelope
import io.reactivex.Single

class HomeRepository {
    interface Network {
        fun getResponse(): Single<Envelope>
    }

    interface File {
        fun readFromFile(): Envelope
        fun saveToFile(envelope: Envelope)
    }
}
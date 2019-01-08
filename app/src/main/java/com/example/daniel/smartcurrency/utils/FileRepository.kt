package com.example.daniel.smartcurrency.utils

import android.content.Context
import android.util.Log
import com.example.daniel.smartcurrency.maincontent.home.HomeContract
import com.example.daniel.smartcurrency.maincontent.home.HomeModel
import com.example.daniel.smartcurrency.maincontent.home.HomeModule
import com.example.daniel.smartcurrency.maincontent.home.HomeRepository
import com.example.daniel.smartcurrency.responsemodels.Envelope
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import javax.inject.Inject

class FileRepository @Inject constructor(var context: Context): HomeRepository.File{
    override fun saveToFile(envelope: Envelope) {
        Log.d("envelope", "" + envelope)
        envelope.setTimestamp(System.currentTimeMillis())
        val fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        objectOutputStream.writeObject(envelope)
        objectOutputStream.close()
        fileOutputStream.close()

        Log.d("envelope", "Saved envelope")
    }

    companion object {
        const val filename = "currencies.txt"
    }

    override fun readFromFile() : Envelope {
        var fileInputStream: FileInputStream = context.openFileInput(filename)
        var objectInputStream = ObjectInputStream(fileInputStream)
        var envelope: Envelope = objectInputStream.readObject() as Envelope
        objectInputStream.close()
        fileInputStream.close()
        return envelope
    }


}
package com.example.rickapimorty

import android.app.Application
import com.example.rickapimorty.data.remote.RetrofitClient

class App : Application() {

    companion object{
        val retrofitClient = RetrofitClient()
    }
}
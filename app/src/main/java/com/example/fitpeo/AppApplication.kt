package com.example.fitpeo

import android.app.Application
import com.example.fitpeo.di.AppComponents
import com.example.fitpeo.di.DaggerAppComponents

class AppApplication: Application() {

    lateinit var appComponents: AppComponents
    override fun onCreate() {
        super.onCreate()
        appComponents= DaggerAppComponents.builder().build()
    }
}
package com.example.fitpeo.di

import com.example.fitpeo.ui.fragments.PhotoListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponents {
    fun inject(photoListFragment: PhotoListFragment)
}
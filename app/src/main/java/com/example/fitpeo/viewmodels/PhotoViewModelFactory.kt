package com.example.fitpeo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitpeo.repository.PhotoRepository
import javax.inject.Inject

class PhotoViewModelFactory @Inject constructor(private val repository: PhotoRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(repository) as T
    }
}
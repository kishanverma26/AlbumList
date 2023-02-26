package com.example.fitpeo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitpeo.models.PhotoRes
import com.example.fitpeo.repository.PhotoRepository
import kotlinx.coroutines.launch

class PhotoViewModel(val repository: PhotoRepository) : ViewModel() {

    val photoList: LiveData<ArrayList<PhotoRes>>
    get() = repository.photoList

    init {
        getList()
    }
     fun getList(){
         if (photoList.value==null) {
             viewModelScope.launch {
                 repository.getPhoto()
             }
         }
    }
}
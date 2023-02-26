package com.example.fitpeo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitpeo.api.PhotoAPI
import com.example.fitpeo.models.PhotoRes
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val photoAPI: PhotoAPI) {

    private val _photoList= MutableLiveData<ArrayList<PhotoRes>>()
     val photoList: LiveData<ArrayList<PhotoRes>>
    get() = _photoList

    suspend fun getPhoto(){
        val result = photoAPI.getPhoto()
        if (result.isSuccessful){
            _photoList.postValue(result.body())
        }
    }
}
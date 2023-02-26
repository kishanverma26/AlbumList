package com.example.fitpeo.api

import com.example.fitpeo.models.PhotoRes
import retrofit2.Response
import retrofit2.http.GET

interface PhotoAPI {
    @GET("photos")
    suspend fun getPhoto() : Response<ArrayList<PhotoRes>>
}
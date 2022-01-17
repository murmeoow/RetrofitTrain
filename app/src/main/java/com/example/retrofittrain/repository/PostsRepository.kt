package com.example.retrofittrain.repository

import androidx.lifecycle.LiveData
import com.example.retrofittrain.models.PostIListResponse
import com.example.retrofittrain.models.PostIListResponseItem
import com.example.retrofittrain.network.RetrofitInstance

class PostsRepository {

    suspend fun getPostsList(): PostIListResponseItem{
        return RetrofitInstance.api.getPostsList()
    }
}
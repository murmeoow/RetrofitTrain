package com.example.retrofittrain.network

import com.example.retrofittrain.models.PostIListResponse
import com.example.retrofittrain.models.PostIListResponseItem
import retrofit2.http.GET


interface PostsApi {

    @GET("posts/1")
    suspend fun getPostsList(): PostIListResponseItem
}
package com.example.retrofittrain.repository

import com.example.retrofittrain.models.PostIListResponseItem
import com.example.retrofittrain.network.RetrofitInstance
import retrofit2.Response

class PostsRepository {

    suspend fun getPostsList(auth: String): Response<PostIListResponseItem> {
        return RetrofitInstance.api.getPostsList(auth)
    }

    suspend fun getPostsList2(number: Int): Response<PostIListResponseItem> {
        return RetrofitInstance.api.getPostsList2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<PostIListResponseItem>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<PostIListResponseItem>> {
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

    suspend fun pushPost(post: PostIListResponseItem): Response<PostIListResponseItem>{
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<PostIListResponseItem>{
        return RetrofitInstance.api.pushPost2(userId, id,title, body)
    }
}
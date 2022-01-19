package com.example.retrofittrain.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittrain.models.PostIListResponseItem
import com.example.retrofittrain.repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: PostsRepository): ViewModel() {

    val myResponse : MutableLiveData<Response<PostIListResponseItem>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<PostIListResponseItem>> = MutableLiveData()
    val myResponse3 : MutableLiveData<Response<List<PostIListResponseItem>>> = MutableLiveData()
    val myResponse4 : MutableLiveData<Response<List<PostIListResponseItem>>> = MutableLiveData()

    fun getPost(auth: String) = viewModelScope.launch {
        val response= repository.getPostsList(auth)
        myResponse.value = response
    }

    fun getPost2(number: Int) = viewModelScope.launch {
        val response= repository.getPostsList2(number)
        myResponse2.value = response
    }

    fun getCustomPost(userId: Int, sort: String, order: String) = viewModelScope.launch {
        val response= repository.getCustomPosts(userId, sort, order)
        myResponse3.value = response
    }

    fun getCustomPost2(userId: Int, options: Map<String, String>) = viewModelScope.launch {
        val response= repository.getCustomPosts2(userId, options)
        myResponse4.value = response
    }

}
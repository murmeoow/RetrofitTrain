package com.example.retrofittrain.network

import com.example.retrofittrain.models.PostIListResponseItem
import retrofit2.Response
import retrofit2.http.*


interface PostsApi {

//    @Headers(
//        "Authorization : 123123123"
//    )
    @GET("posts/1")
    suspend fun getPostsList(@Header("Auth") auth : String): Response<PostIListResponseItem>

    @GET("posts/{postNumber}")
    suspend fun getPostsList2(
        @Path("postNumber") number: Int
    ): Response<PostIListResponseItem>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query ("userId") userId: Int,
        @Query ("_sort") sort: String,
        @Query ("_order") order: String,
    ): Response<List<PostIListResponseItem>>

    @GET("posts")
    suspend fun getCustomPosts2(
        @Query ("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<PostIListResponseItem>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: PostIListResponseItem
    ): Response<PostIListResponseItem>

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId : Int,
        @Field("id") id : Int,
        @Field("title") title : String,
        @Field("body") body : String,
    ): Response<PostIListResponseItem>

}
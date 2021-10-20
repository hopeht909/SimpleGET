package com.example.simpleget

import retrofit2.Call
import retrofit2.http.*



interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/people/")
    fun getUser(): Call<List<People.PeopleDetailed>>

}
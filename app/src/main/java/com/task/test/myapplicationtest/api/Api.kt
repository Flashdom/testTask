package com.task.test.myapplicationtest.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("test.php")
    fun getCompanies(): Call<List<Companies>>

    @GET("test.php")
    fun getCompany(@Query("id") id:String) : Call<List<Company>>


    companion object Factory {
        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://megakohz.bget.ru/test_task/")
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}
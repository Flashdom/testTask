package com.task.test.myapplicationtest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.task.test.myapplicationtest.api.Api
import com.task.test.myapplicationtest.api.Companies
import com.task.test.myapplicationtest.api.Company
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepo {

    private val apiService: Api = Api.create()

    fun getCompanies(): MutableLiveData<List<Companies>> {
        val data = MutableLiveData<List<Companies>>()
        apiService.getCompanies().enqueue(object : Callback<List<Companies>> {
            override fun onFailure(call: Call<List<Companies>>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }


            override fun onResponse(call: Call<List<Companies>>?, response: Response<List<Companies>>?) {
                data.value = response!!.body()
            }

        })
        return data
    }

    fun getCompany(id: String): MutableLiveData<List<Company>> {
        val data = MutableLiveData<List<Company>>()
        apiService.getCompany(id).enqueue(
            object : Callback<List<Company>> {
                override fun onFailure(call: Call<List<Company>>, t: Throwable) {
                    Log.v("retrofit", "call failed")
                }


                override fun onResponse(call: Call<List<Company>>, response: Response<List<Company>>) {
                    data.value = response.body()
                }

            })
            return data
    }

}
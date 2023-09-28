package com.emilabdurahmanli.brodcastreciever.network

import com.emilabdurahmanli.brodcastreciever.Constant
import com.emilabdurahmanli.brodcastreciever.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    fun getApi() : Api {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(Api::class.java)
    }
}
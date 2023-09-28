package com.emilabdurahmanli.brodcastreciever.api

import com.emilabdurahmanli.brodcastreciever.model.DummyModel
import retrofit2.Call
import retrofit2.http.GET




interface Api {

    @GET("products/1")
    fun getDummyData(): Call<DummyModel>
}
package com.emilabdurahmanli.brodcastreciever

import com.emilabdurahmanli.brodcastreciever.model.DummyModel
import com.emilabdurahmanli.brodcastreciever.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class DataFetcher {

    fun getDummy(callback : IDataCallback){
        RetrofitClient.getApi().getDummyData().enqueue(object : Callback<DummyModel>{
            override fun onResponse(call: Call<DummyModel>, response: Response<DummyModel>) {
                callback.callback(DataResult.Success(response.body()))
            }

            override fun onFailure(call: Call<DummyModel>, t: Throwable) {
                callback.callback(DataResult.Failure(t.localizedMessage!!.toString()))
            }

        })
    }

}

interface IDataCallback{
    fun callback(result : DataResult)
}
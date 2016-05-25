package com.yangpeiyong.appdemokotlin.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by yangpeiyong on 16/1/12.
 */
interface ApiService {
    //http://gank.avosapps.com/api/data/Android/2/2
    @GET("Android/{pageSize}/{pageCount}")
    fun articles(@Path("pageSize") pageSize: Int, @Path("pageCount") pageCount: Int): Call<ReceiveData.ArticleListResponse>
}

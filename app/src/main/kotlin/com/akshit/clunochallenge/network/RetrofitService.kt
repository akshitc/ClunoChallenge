package com.akshit.clunochallenge.network

import com.akshit.clunochallenge.model.ClunoCarDetailResponse
import com.akshit.clunochallenge.model.ClunoListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("/offerservice/v1/offer/query")
    fun getCars(): Single<ClunoListResponse>

    @GET("/offerservice/v1/offer/{id}")
    fun getCarDetail(@Path("id") id: String): Single<ClunoCarDetailResponse>
}

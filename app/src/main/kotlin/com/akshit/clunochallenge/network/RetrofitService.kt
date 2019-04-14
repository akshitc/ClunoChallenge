package com.akshit.clunochallenge.network

import com.akshit.clunochallenge.model.ClunoListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/offerservice/v1/offer/query")
    fun getCars(): Single<ClunoListResponse>
}

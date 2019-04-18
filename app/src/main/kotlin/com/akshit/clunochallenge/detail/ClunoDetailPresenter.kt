package com.akshit.clunochallenge.detail

import com.akshit.clunochallenge.model.ClunoCarDetailResponse
import com.akshit.clunochallenge.model.ClunoListResponse
import com.akshit.clunochallenge.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ClunoDetailPresenter(
    val view: ClunoDetailView,
    val service: RetrofitService
) {
    fun fetchDetails(id: String) {
        service.getCarDetail(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(DetailObserver())
    }

    inner class DetailObserver : DisposableSingleObserver<ClunoCarDetailResponse>() {
        override fun onSuccess(response: ClunoCarDetailResponse) {
            view.showDetail(response)
        }

        override fun onError(error: Throwable) {
            view.showError()
        }
    }
}

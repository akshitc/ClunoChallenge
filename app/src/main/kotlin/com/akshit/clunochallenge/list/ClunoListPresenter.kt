package com.akshit.clunochallenge.list

import com.akshit.clunochallenge.model.ClunoListResponse
import com.akshit.clunochallenge.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ClunoListPresenter(
    val view: ClunoListView,
    val service: RetrofitService
) {

    fun fetchCars() {
        service.getCars()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(ListObserver())
    }

    inner class ListObserver : DisposableSingleObserver<ClunoListResponse>() {
        override fun onSuccess(response: ClunoListResponse) {
            view.showCars(response)
        }

        override fun onError(error: Throwable) {
            view.showError()
        }
    }
}

package com.akshit.clunochallenge.list

import com.akshit.clunochallenge.model.ClunoListResponse
import com.akshit.clunochallenge.network.RetrofitService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ClunoListPresenterTest {

    val view: ClunoListView = mock()
    val service: RetrofitService = mock()
    lateinit var presenter: ClunoListPresenter

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        presenter = ClunoListPresenter(view, service)
    }

    @Test
    fun showCarsWhenFetchingCarsIsSuccessful() {
        val response = ClunoListResponse()
        whenever(service.getCars()).thenReturn(Single.just(response))
        presenter.fetchCars()
        verify(view).showCars(response)
    }

    @Test
    fun showErrorWhenFetchingCarsFailed() {
        whenever(service.getCars()).thenReturn(Single.error(Throwable()))
        presenter.fetchCars()
        verify(view).showError()
    }
}
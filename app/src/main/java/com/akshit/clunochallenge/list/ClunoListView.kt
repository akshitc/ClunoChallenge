package com.akshit.clunochallenge.list

import com.akshit.clunochallenge.model.ClunoListResponse

interface ClunoListView {
    fun showCars(response: ClunoListResponse)

    fun showError()
}

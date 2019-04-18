package com.akshit.clunochallenge.detail

import com.akshit.clunochallenge.model.ClunoCarDetailResponse

interface ClunoDetailView {
    fun showDetail(response: ClunoCarDetailResponse)

    fun showError()
}

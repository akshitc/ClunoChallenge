package com.akshit.clunochallenge.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akshit.clunochallenge.R
import com.akshit.clunochallenge.model.ClunoListResponse
import com.akshit.clunochallenge.network.RetrofitFactory
import kotlinx.android.synthetic.main.fragment_cluno_list.*

/**
 * A [Fragment] subclass to display catalogue of cars
 *
 */
class ClunoListFragment : Fragment(), ClunoListView {

    lateinit var presenter: ClunoListPresenter
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cluno_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ClunoListPresenter(this, RetrofitFactory.getRetrofitService())
        initViews()
    }

    private fun initViews() {
        viewManager = LinearLayoutManager(context)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }
        presenter.fetchCars()
    }

    override fun showCars(response: ClunoListResponse) {

    }

    override fun showError() {

    }
}

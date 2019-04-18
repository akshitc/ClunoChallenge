package com.akshit.clunochallenge.list


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.akshit.clunochallenge.R
import com.akshit.clunochallenge.detail.ClunoDetailActivity
import com.akshit.clunochallenge.model.ClunoListItem
import com.akshit.clunochallenge.model.ClunoListResponse
import com.akshit.clunochallenge.network.RetrofitFactory
import kotlinx.android.synthetic.main.fragment_cluno_list.*


/**
 * A [Fragment] subclass to display catalogue of cars
 *
 */
class ClunoListFragment : Fragment(), ClunoListView, OnItemClickListener {

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
            addItemDecoration(DividerItemDecoration(context, (viewManager as LinearLayoutManager).orientation));
        }
        presenter.fetchCars()
    }

    override fun onItemClick(item: ClunoListItem) {
        val intent = Intent(context, ClunoDetailActivity::class.java)
        intent.putExtra(ClunoDetailActivity.ID, item.id)
        startActivity(intent)
    }

    override fun showCars(response: ClunoListResponse) {
        recyclerView.adapter = ClunoListAdapter(response.items, this)
    }

    override fun showError() {
        Toast.makeText(context, R.string.error_text, Toast.LENGTH_LONG).show()
    }
}

interface OnItemClickListener {
    fun onItemClick(item: ClunoListItem)
}

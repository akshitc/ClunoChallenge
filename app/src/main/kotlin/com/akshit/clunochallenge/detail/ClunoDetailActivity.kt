package com.akshit.clunochallenge.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.akshit.clunochallenge.R

class ClunoDetailActivity : AppCompatActivity() {

    companion object {
        const val ID: String = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cluno_detail)

        launchFragment(intent.getStringExtra(ID))
    }

    private fun launchFragment(id: String?) {
        if (id != null) {
            supportFragmentManager.beginTransaction().apply {
                replace(
                    R.id.detailsContainer,
                    ClunoDetailFragment.newInstance(id)
                )
                commit()
            }
        }
    }
}

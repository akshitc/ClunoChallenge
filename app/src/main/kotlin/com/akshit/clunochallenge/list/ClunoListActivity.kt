package com.akshit.clunochallenge.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.akshit.clunochallenge.R

class ClunoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cluno_list)

        launchFragment()
    }

    private fun launchFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(
                R.id.list_fragment_container,
                ClunoListFragment()
            )
            commit()
        }
    }
}

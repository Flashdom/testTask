package com.task.test.myapplicationtest.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.test.myapplicationtest.R
import com.task.test.myapplicationtest.api.Companies
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    private lateinit var myAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.compList) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        mainActivityViewModel.getCompanies().observe(this, Observer<List<Companies>> { companies ->
            myAdapter = MainAdapter(companies, object : OnItemClicked {
                override fun onItemClicked(item: Companies) {
                    intent = Intent(this@MainActivity, CompanyDetailActivity::class.java)
                    intent.putExtra("id", item.id)
                    startActivity(intent)

                }

            })
            compList.adapter = myAdapter
        })

    }
}

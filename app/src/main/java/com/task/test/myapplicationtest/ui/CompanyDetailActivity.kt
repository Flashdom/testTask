package com.task.test.myapplicationtest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.task.test.myapplicationtest.R
import com.task.test.myapplicationtest.api.Company
import kotlinx.android.synthetic.main.activity_company_detail.*


class CompanyDetailActivity : AppCompatActivity() {
    private val companyViewModel: CompanyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_detail)
        val id1:String = intent.getStringExtra("id")

        companyViewModel.getCompany(id1).observe(this, Observer<List<Company>>{company ->
           val link = "http://megakohz.bget.ru/test_task/"
            id.text = company[0].id
            name.text = company[0].name
            description.text = company[0].description
            latitude.text = (company[0].lat).toString()
            longtitude.text = (company[0].lon).toString()
            website.text = company[0].www
            phone.text = company[0].phone
            Picasso.get().load(link + company[0].img).into(picture)


        })
    }
}

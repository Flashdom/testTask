package com.task.test.myapplicationtest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.task.test.myapplicationtest.api.Company

class CompanyViewModel : ViewModel() {
    private val repo: DataRepo = DataRepo

    fun getCompany(id: String): LiveData<List<Company>> {
        return repo.getCompany(id)
    }

}
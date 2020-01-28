package com.task.test.myapplicationtest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.task.test.myapplicationtest.api.Companies

class MainActivityViewModel : ViewModel() {

    private val repo: DataRepo = DataRepo

    fun getCompanies(): LiveData<List<Companies>> {
        return repo.getCompanies()
    }


}
package com.example.jetpackcomponentapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomponentapp.DataClass
import com.example.jetpackcomponentapp.database.DbBuilder
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class ViewModelclass(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    lateinit var allPersons: LiveData<List<DataClass>>
    private val roomDatabaseBuilder = DbBuilder.getInstance(context)

    init {
        getAllPersonsDetails()
    }

    private fun getAllPersonsDetails() {
        viewModelScope.launch {
            val persons = roomDatabaseBuilder.personDao().getAllPersonsDetails()
            allPersons = persons
        }
    }

    fun addPersonDetails(personDataClass: DataClass) {
        Executors.newSingleThreadExecutor().execute {
            roomDatabaseBuilder.personDao().insertPersonDetails(
                DataClass(
                    personId = personDataClass.personId,
                    personName = personDataClass.personName,
                    personContact = personDataClass.personContact,
                    personAddress = personDataClass.personAddress
                )
            )
        }
    }
}
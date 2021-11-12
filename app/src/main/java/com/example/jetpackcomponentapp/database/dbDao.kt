package com.example.jetpackcomponentapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackcomponentapp.DataClass

@Dao
interface dbDao {
    @Query("SELECT * FROM person_table")
    fun getAllPersonsDetails(): LiveData<List<DataClass>>

    @Insert
    fun insertPersonDetails(person: DataClass)
}
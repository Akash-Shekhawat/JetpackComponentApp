package com.example.jetpackcomponentapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomponentapp.DataClass

@Database(entities = [DataClass::class], version = 2)
abstract class Databaseclass : RoomDatabase() {
    abstract fun personDao() : dbDao
}
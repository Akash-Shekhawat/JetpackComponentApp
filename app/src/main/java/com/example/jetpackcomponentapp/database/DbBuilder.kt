package com.example.jetpackcomponentapp.database

import android.content.Context
import androidx.room.Room

object DbBuilder {
    private var INSTANCE: Databaseclass? = null

    fun getInstance(context: Context): Databaseclass {
        if (INSTANCE == null) {
            synchronized(Databaseclass::class) {
                INSTANCE =
                    buildRoomDB(
                        context
                    )
            }
        }
        return INSTANCE!!
    }

    // Creating database using Room
    private fun buildRoomDB(context: Context): Databaseclass? {
        return Room.databaseBuilder(context, Databaseclass::class.java, "person_db")
            .fallbackToDestructiveMigration().build()
    }
}
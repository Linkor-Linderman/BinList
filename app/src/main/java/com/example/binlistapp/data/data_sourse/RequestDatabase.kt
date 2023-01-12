package com.example.binlistapp.data.data_sourse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binlistapp.domain.model.Request

@Database(
    entities = [Request::class],
    version = 1
)
abstract class RequestDatabase: RoomDatabase() {
    abstract val requestDao: RequestDao

    companion object {
        const val DATABASE_NAME = "request_db"
    }
}
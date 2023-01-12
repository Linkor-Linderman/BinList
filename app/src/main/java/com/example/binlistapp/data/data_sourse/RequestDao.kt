package com.example.binlistapp.data.data_sourse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binlistapp.domain.model.Request
import kotlinx.coroutines.flow.Flow


@Dao
interface RequestDao {
    @Query("SELECT * FROM request")
    fun getRequests(): Flow<List<Request>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRequest(request: Request)

}
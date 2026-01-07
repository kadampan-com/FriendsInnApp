package com.friendsinn.calendar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.friendsinn.calendar.data.entity.BookableUnit

@Dao
interface UnitDao {

    @Query("SELECT COUNT(*) FROM BookableUnit")
    suspend fun countUnits(): Int

    @Query("SELECT * FROM BookableUnit ORDER BY unitCode ASC")
    suspend fun getAllUnits(): List<BookableUnit>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(units: List<BookableUnit>): List<Long>
}

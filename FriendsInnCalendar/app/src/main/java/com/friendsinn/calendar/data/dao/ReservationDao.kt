package com.friendsinn.calendar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.friendsinn.calendar.data.entity.Reservation

@Dao
interface ReservationDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(reservation: Reservation): Long

    // Overlap rule: newStart < existingEnd AND newEnd > existingStart (ignore cancelled)
    @Query(
        """
        SELECT * FROM Reservation
        WHERE unitId = :unitId
          AND :newStart < endDate
          AND :newEnd > startDate
          AND status != 'CANCELLED'
        ORDER BY startDate ASC
        """
    )
    suspend fun findConflicts(
        unitId: Long,
        newStart: Long,
        newEnd: Long
    ): List<Reservation>
}

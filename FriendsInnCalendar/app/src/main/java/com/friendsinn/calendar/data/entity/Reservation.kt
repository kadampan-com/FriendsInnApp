package com.friendsinn.calendar.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index("unitId"),
        Index("startDate"),
        Index("endDate"),
        Index("status")
    ]
)
data class Reservation(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val unitId: Long,
    val guestName: String,
    val guestPhone: String = "",
    val startDate: Long,           // epoch millis (local midnight)
    val endDate: Long,             // epoch millis (exclusive)
    val status: String = "BOOKED", // BOOKED, CHECKED_IN, CHECKED_OUT, CANCELLED
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

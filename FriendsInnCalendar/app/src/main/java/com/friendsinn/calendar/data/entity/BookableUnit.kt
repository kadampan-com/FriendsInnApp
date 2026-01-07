package com.friendsinn.calendar.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index(value = ["unitCode"], unique = true),
        Index(value = ["unitType"])
    ]
)
data class BookableUnit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val unitCode: String,      // "101", "201", "HALL1", "HALL2"
    val displayName: String,   // "Room 101", "Reception Hall 1"
    val unitType: String,      // "ROOM" or "HALL"
    val isActive: Boolean = true
)

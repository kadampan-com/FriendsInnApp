package com.friendsinn.calendar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.friendsinn.calendar.data.dao.ReservationDao
import com.friendsinn.calendar.data.dao.UnitDao
import com.friendsinn.calendar.data.entity.BookableUnit
import com.friendsinn.calendar.data.entity.Reservation

@Database(
    entities = [BookableUnit::class, Reservation::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun unitDao(): UnitDao
    abstract fun reservationDao(): ReservationDao
}

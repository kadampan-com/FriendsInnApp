package com.friendsinn.calendar.data.db

import android.content.Context
import androidx.room.Room

object DbProvider {

    @Volatile private var INSTANCE: AppDb? = null

    fun get(context: Context): AppDb =
        INSTANCE ?: synchronized(this) {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDb::class.java,
                "friends_inn_calendar.db"
            ).build()
            INSTANCE = db
            db
        }
}

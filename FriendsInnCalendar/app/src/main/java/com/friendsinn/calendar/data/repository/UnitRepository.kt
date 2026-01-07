package com.friendsinn.calendar.data.repository

import com.friendsinn.calendar.data.dao.UnitDao
import com.friendsinn.calendar.data.entity.BookableUnit

class UnitRepository(
    private val unitDao: UnitDao
) {
    suspend fun getAllUnits(): List<BookableUnit> {
        return unitDao.getAllUnits()
    }
}

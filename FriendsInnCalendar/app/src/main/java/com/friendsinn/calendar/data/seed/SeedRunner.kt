package com.friendsinn.calendar.data.seed

import com.friendsinn.calendar.data.dao.UnitDao

object SeedRunner {
    suspend fun seedIfEmpty(unitDao: UnitDao) {
        if (unitDao.countUnits() > 0) return
        unitDao.insertAll(SeedData.defaultUnits())
    }
}

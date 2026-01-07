package com.friendsinn.calendar.data.seed

import com.friendsinn.calendar.data.entity.BookableUnit

object SeedData {

    fun defaultUnits(): List<BookableUnit> {

        val rooms101to110 = (101..110).map { no ->
            BookableUnit(
                unitCode = no.toString(),
                displayName = "Room $no",
                unitType = "ROOM"
            )
        }

        val rooms201to206 = (201..206).map { no ->
            BookableUnit(
                unitCode = no.toString(),
                displayName = "Room $no",
                unitType = "ROOM"
            )
        }

        val halls = listOf(
            BookableUnit(
                unitCode = "HALL1",
                displayName = "Reception Hall 1",
                unitType = "HALL"
            ),
            BookableUnit(
                unitCode = "HALL2",
                displayName = "Reception Hall 2",
                unitType = "HALL"
            )
        )

        return rooms101to110 + rooms201to206 + halls
    }
}

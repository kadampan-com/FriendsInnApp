package com.friendsinn.calendar.ui.units

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.friendsinn.calendar.data.db.DbProvider
import com.friendsinn.calendar.data.repository.UnitRepository

class UnitsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = DbProvider.get(context)
        val repo = UnitRepository(db.unitDao())
        @Suppress("UNCHECKED_CAST")
        return UnitsViewModel(repo) as T
    }
}

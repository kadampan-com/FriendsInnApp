package com.friendsinn.calendar.ui.units

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.friendsinn.calendar.data.entity.BookableUnit
import com.friendsinn.calendar.data.repository.UnitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UnitsViewModel(private val repository: UnitRepository) : ViewModel() {

    private val _units = MutableStateFlow<List<BookableUnit>>(emptyList())
    val units: StateFlow<List<BookableUnit>> = _units

    fun loadUnits() {
        viewModelScope.launch {
            _units.value = repository.getAllUnits()
        }
    }
}

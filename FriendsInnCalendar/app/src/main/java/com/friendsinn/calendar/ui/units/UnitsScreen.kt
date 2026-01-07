package com.friendsinn.calendar.ui.units

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.friendsinn.calendar.data.entity.BookableUnit

@Composable
fun UnitsScreen(viewModel: UnitsViewModel) {
    val units = viewModel.units.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(units.value) { unit ->
            UnitRow(unit)
        }
    }
}

@Composable
private fun UnitRow(unit: BookableUnit) {
    Card(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "${unit.displayName} (${unit.unitType})",
            modifier = Modifier.padding(16.dp)
        )
    }
}

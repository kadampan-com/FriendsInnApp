package com.friendsinn.calendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.friendsinn.calendar.ui.theme.FriendsInnCalendarTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DB + Seed must be AFTER super.onCreate(...)
        val db = com.friendsinn.calendar.data.db.DbProvider.get(applicationContext)
        lifecycleScope.launch(Dispatchers.IO) {
            com.friendsinn.calendar.data.seed.SeedRunner.seedIfEmpty(db.unitDao())
        }

        enableEdgeToEdge()

        setContent {setContent {
            FriendsInnCalendarTheme {

                val factory = com.friendsinn.calendar.ui.units.UnitsViewModelFactory(applicationContext)

                val viewModel =
                    androidx.lifecycle.viewmodel.compose.viewModel<com.friendsinn.calendar.ui.units.UnitsViewModel>(
                        factory = factory
                    )

                androidx.compose.runtime.LaunchedEffect(Unit) {
                    viewModel.loadUnits()
                }

                com.friendsinn.calendar.ui.units.UnitsScreen(viewModel)
            }
        }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FriendsInnCalendarTheme {
        Greeting("Friends Inn")
    }
}

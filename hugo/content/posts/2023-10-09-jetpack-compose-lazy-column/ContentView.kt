package com.swiswiswift.swiswikotlin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val pokemons = listOf(
        "Bulbasaur",
        "Ivysaur",
        "Venusaur",
        "Charmander",
        "Charmeleon",
        "Charizard",
        "Squirtle",
        "Wartortle",
        "Blastoise",
        "Caterpie",
        "Metapod",
        "Butterfree",
        "Weedle",
        "Kakuna",
        "Beedrill"
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(pokemons, key = { it }) { pokemon ->
            Text(
                text = pokemon,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            HorizontalDivider()
        }
    }
}

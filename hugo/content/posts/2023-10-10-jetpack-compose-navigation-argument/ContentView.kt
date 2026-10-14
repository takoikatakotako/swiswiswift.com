package com.swiswiswift.swiswikotlin

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(navController: NavController, modifier: Modifier = Modifier) {
    val pokemons = arrayOf(
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

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 36.dp)
    ) {
        items(pokemons) { pokemon ->
            Column(modifier = Modifier.clickable {
                navController.navigate(Route.PokemonDetail.name + "/" + Uri.encode(pokemon))
            }) {
                Text(
                    pokemon,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp))
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView(rememberNavController())
    }
}

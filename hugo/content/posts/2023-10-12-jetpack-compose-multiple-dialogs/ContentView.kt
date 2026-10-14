package com.swiswiswift.swiswikotlin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val openSnorlaxDialog = remember { mutableStateOf(false) }
    val openPikachuDialog = remember { mutableStateOf(false) }

    // Snorlax Dialog
    if (openSnorlaxDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Snorlax")
            },
            text = {
                Text("Snorlax is a Normal-type Pokémon introduced in Generation I.\nIt evolves from Munchlax when leveled up with high friendship.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openSnorlaxDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = null
        )
    }

    // Pikachu Dialog
    if (openPikachuDialog.value) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Pikachu")
            },
            text = {
                Text("When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openPikachuDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = null
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                openSnorlaxDialog.value = true
            }
        ) {
            Text("Showing Snorlax Dialog")
        }

        Button(
            onClick = {
                openPikachuDialog.value = true
            }
        ) {
            Text("Showing Pikachu Dialog")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView()
    }
}

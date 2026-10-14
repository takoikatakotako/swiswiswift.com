package com.swiswiswift.swiswikotlin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    var openIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    val names = listOf("Snorlax", "Pikachu", "Ditto", "Slowpoke")
    val descriptions = listOf(
        "This is Snorlax.\n".repeat(12),
        "This is Pikachu.\n".repeat(12),
        "This is Ditto.\n".repeat(12),
        "This is Slowpoke.\n".repeat(12)
    )

    LaunchedEffect(openIndex) {
        val index = openIndex ?: return@LaunchedEffect
        delay(300)
        listState.animateScrollToItem(index)
    }

    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(names, key = { _, name -> name }) { index, name ->
            PokemonCard(
                open = openIndex == index,
                title = name,
                description = descriptions[index],
                tap = { openIndex = if (openIndex == index) null else index }
            )
        }
    }
}

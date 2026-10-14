package com.swiswiswift.swiswikotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme

@Composable
fun ContentView(innerPadding: PaddingValues = PaddingValues()) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Image(
            modifier = Modifier
                .size(42.dp, 42.dp),
            painter = painterResource(id = R.drawable.snorlax),
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.snorlax)
        )

        Spacer(modifier = Modifier.weight(1.0f))
    }
}

@Preview(showBackground = true)
@Composable
fun ContentViewPreview() {
    MaterialTheme {
        ContentView()
    }
}

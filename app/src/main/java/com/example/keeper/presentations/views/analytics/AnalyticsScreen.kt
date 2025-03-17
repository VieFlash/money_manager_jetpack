package com.example.keeper.presentations.views.analytics

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.keeper.presentations.widgets.AutoResizeText

@Composable
fun AnalyticsScreen() {
    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val maxWidth = this.maxWidth
        val maxHeight = this.maxHeight

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp) // Example usage
        ) {
            AutoResizeText("Max Width: $maxWidth, Max Height: $maxHeight")
        }
    }
}

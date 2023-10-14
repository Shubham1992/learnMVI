package com.shubham.learnmvi

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen() {
    Surface {
        Column(modifier = Modifier) {
            Text(text = "Detail Screen")
        }
    }
}
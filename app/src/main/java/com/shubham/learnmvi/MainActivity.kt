package com.shubham.learnmvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { MainScreen(viewModel) }


    }

    @Composable
    fun MainScreen(viewModel: MainScreenViewModel) {
        var count = remember { mutableStateOf(0) }

        LaunchedEffect(key1 = viewModelStore) {
            viewModel.state.collect { state -> count.value = state.count }
        }
        Surface(
            modifier = Modifier.fillMaxWidth().height(500.dp),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Count: ${count.value}", style = MaterialTheme.typography.h4)

                Spacer(modifier = Modifier.weight(0.2f))

                CounterButton(text = "Increment") {
                    viewModel.handleIntent(MainScreenIntent.Increment)
                }

                Spacer(modifier = Modifier.weight(0.1f))

                CounterButton(text = "Decrement") {
                    viewModel.handleIntent(MainScreenIntent.Decrement)
                }
            }
        }
    }

    @Composable
    fun CounterButton(text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {
            Text(text = text)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCounterView() {
//        val model = MainScreenViewModel()
//        MainScreen(model)
    }
}

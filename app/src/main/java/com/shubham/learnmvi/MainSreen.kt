package com.shubham.learnmvi

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation


@Composable
fun MainScreen(navigation: NavController) {

    val viewModel: MainScreenViewModel = hiltViewModel()
    val context = LocalContext.current
    var count = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = viewModel) {
        viewModel?.state?.collect { state -> count.value = state.count }
    }
    Surface(
        modifier = Modifier.fillMaxWidth().height(550.dp),
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
                viewModel?.handleIntent(MainScreenIntent.Increment)
            }

            Spacer(modifier = Modifier.weight(0.1f))

            CounterButton(text = "Decrement") {
                viewModel?.handleIntent(MainScreenIntent.Decrement)
            }

            Spacer(modifier = Modifier.weight(0.1f))

            Button(onClick = {
                navigation.navigate(
                    route = AppScreens.DetailScreen.route
                )
            }) {
                Text(text = "Go to next screen")
            }

            Spacer(modifier = Modifier.weight(0.1f))

            Button(onClick = {
                Toast.makeText(context,  "", Toast.LENGTH_SHORT).show()

                viewModel.handleIntent(MainScreenIntent.GetMovies)

            }) {
                Text(text = "Get movie list")
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
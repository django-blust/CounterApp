package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) } // State to track the count

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // Display the count
            Text(text = "Count: $count", fontSize = 32.sp, modifier = Modifier.padding(16.dp))

            // Increment Button
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Increment")
            }

            // Decrement Button
            Button(
                onClick = { if (count > 0) count-- }, // Ensure count doesn't go below 0
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Decrement")
            }

            // Reset Button
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset")
            }
        }
    }
}

package com.example.caloriecalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CalorieScreen() {
    var weightInput by remember { mutableStateOf("") }
    var isMale by remember { mutableStateOf(true) }
    var activityIntensity by remember { mutableStateOf(1.3f) } // Default intensity
    var calorieResult by remember { mutableStateOf(0) } // Result to display

    Column(
        modifier = Modifier.padding(16.dp), // Added padding for better layout
        verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
    ) {
        Heading(title = stringResource(R.string.calories)) // Title heading
        WeightField(weightInput = weightInput, onValueChange = { weightInput = it }) // Input for weight
        Gender(isMale, setGenderMale = { isMale = it }) // Gender selection with Boolean
        IntensityList(onClick = { activityIntensity = it }) // Activity intensity dropdown
        Text(
            text = "Calories Burned: $calorieResult",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )
        Calculation(
            male = isMale,
            weight = weightInput.toIntOrNull() ?: 0, // Converting to Int safely to prevent crashes
            intensity = activityIntensity,
            setResult = { calorieResult = it }
        )
    }
}
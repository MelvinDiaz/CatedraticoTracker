package com.diaz.catedraticotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.diaz.catedraticotracker.ui.catedraticos.CatedraticoViewModel
import com.diaz.catedraticotracker.ui.navegation.GeneralScaffold
import com.diaz.catedraticotracker.ui.theme.CatedraticoTrackerTheme

class MainActivity : ComponentActivity() {
    private val viewModelCate by viewModels<CatedraticoViewModel> {
        CatedraticoViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatedraticoTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GeneralScaffold(viewModelCate)
                }
            }
        }
    }
}
package com.johnkenedy.imageloadingnavigation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.johnkenedy.imageloadingnavigation.app.navigation.NavigationRoot
import com.johnkenedy.imageloadingnavigation.core.ui.theme.ImageLoadingNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageLoadingNavigationTheme {
                NavigationRoot(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

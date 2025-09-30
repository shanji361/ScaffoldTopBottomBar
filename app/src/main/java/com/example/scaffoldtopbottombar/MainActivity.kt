package com.example.scaffoldtopbottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.scaffoldtopbottombar.ui.theme.ScaffoldTopBottomBarTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlinx.coroutines.launch
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Person

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffoldTopBottomBarTheme {
                ScaffoldWithNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithNavigation() {
    // keep track of which tab is selected
    var selectedTab by remember { mutableIntStateOf(0) }

    // host state (used to show snackbars)
    val snackbarHostState = remember { SnackbarHostState() }

    // coroutine scope for launching snackbar calls
    val scope = rememberCoroutineScope()

    // tabs for bottom navigation
    val tabs = listOf("Home", "Settings", "Profile")

    Scaffold(
        topBar = {
            // top app bar with title
            TopAppBar(
                title = { Text("Example Scaffold") }
            )
        },
        bottomBar = {
            // bottom navigation bar
            NavigationBar {
                tabs.forEachIndexed { index, title ->
                    NavigationBarItem(
                        icon = {
                            when (title) {
                                "Home" -> Icon(Icons.Filled.Home, contentDescription = "Home")
                                "Settings" -> Icon(Icons.Filled.Settings, contentDescription = "Settings")
                                "Profile" -> Icon(Icons.Filled.Person, contentDescription = "Profile")
                            }
                        },
                        label = { Text(title) },
                        selected = selectedTab == index, // highlight selected tab
                        onClick = { selectedTab = index } // update selected tab on click
                    )
                }
            }
        },
        floatingActionButton = {
            // FAB shows snackbar when clicked

            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "FAB Clicked"
                        )
                    }
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        // main content area of the scaffold
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${tabs[selectedTab]} Screen"
            )
        }
    }
}
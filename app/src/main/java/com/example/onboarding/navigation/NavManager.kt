package com.example.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.dataStore.StoreBoarding
import com.example.onboarding.onBoardView.MainOnBoarding
import com.example.onboarding.views.HomeView
import com.example.onboarding.views.SplashScreen

@Composable
fun  NavManager(){
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBOARDING.collectAsState(initial = false)
    val navController = rememberNavController()
    NavHost(navController, startDestination = if(store.value) "Home" else "Splash") {
        composable("OnBoarding"){
            MainOnBoarding(navController, dataStore)
        }
        composable("Home"){
            HomeView(navController)
        }
        composable("Splash"){
            SplashScreen(navController = navController, store.value)
        }
    }
}
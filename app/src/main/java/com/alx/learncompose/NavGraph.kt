package com.alx.learncompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "0"){
        
        composable( route = "0"){
            ScreenA(navController)
        }
        composable( route = "1"){
            ScreenB(navController)
        }
        composable( route = "2"){
            ScreenC(navController)
        }
        
    }


}
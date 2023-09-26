package com.alx.learncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.alx.learncompose.model.Routes

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Tela 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("Tela 2") })
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = "Tela 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("Tela 3") })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Tela 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Tela4.createRoute(54)) })
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = age.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("Tela 5") })
    }
}

    @Composable
    fun Screen5(navController: NavHostController, name: String?) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            Text(
                text = name.toString(),
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { navController.navigate("Tela 5") })
        }
    }

package com.alx.learncompose.model

sealed class Routes(val route: String) {
    object Tela1:Routes("Tela 1")
    object Tela2:Routes("Tela 2")
    object Tela3:Routes("Tela 3")
    object Tela4:Routes("Tela 4/{age}"){
        fun createRoute(age: Int) = "Tela 4/$age"
    }
    object Tela5:Routes("Tela 5?name={name}"){
        fun createRoute(name: String) = "Tela 5?name=$name"
    }
}
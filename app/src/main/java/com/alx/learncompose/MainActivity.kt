package com.alx.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alx.learncompose.model.Routes
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

    
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContent {
            
            myDrawer()
            Surface{
               val navigationController = rememberNavController()
//                NavHost(navController = navigationController, startDestination = Routes.Tela1.route ){
//                    composable(Routes.Tela1.route){
//                        Screen1(navigationController)
//                    }
//                    composable(Routes.Tela2.route){
//                        Screen2(navigationController)
//                    }
//                    composable(Routes.Tela3.route){
//                        Screen3(navigationController)
//                    }
//                    composable(Routes.Tela4.route, arguments = listOf(navArgument("age") { type = NavType.IntType})){
//                        Screen4(navController = navigationController, age = it.arguments?.getInt("age") ?: 0 )
//                    }
//                    composable(Routes.Tela5.route, arguments = listOf(navArgument("name") {
//                        defaultValue = "pagina"
//                    }) ){
//                        Screen5(navController = navigationController, name = it.arguments?.getString("name") )
//                    }
//
//                }
                Scaffold()
                //RecycleView()
                //SuperHeroView()
                //SuperHeroGridView()
                }
            }
            
        }
        
    }


    
    @OptIn(ExperimentalFoundationApi::class)
    @Preview
    @Composable
    private fun HomeScreenPreview() {
    
    }



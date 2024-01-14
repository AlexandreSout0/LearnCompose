package com.alx.learncompose


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    Scaffold(
        topBar = { MyTopAppBar() },
        bottomBar = { MyBottomNavigationBar() },
        floatingActionButton = { MyFloatingActionBotton() },
        floatingActionButtonPosition = FabPosition.Center,
        
    ) {
        Screen1()
    }
    
}


@Composable
fun Screen1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Tela 1",
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Box(
                modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Top App Bar", fontWeight = FontWeight.Bold)
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date")
            }
            
        }
    
    )
}

@Composable
fun MyBottomNavigationBar(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    NavigationBar(
        modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp)),
        containerColor = Color.Red,
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Fav") },
            label = { Text(text = "Fav") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person") },
            label = { Text(text = "Person") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color.White
            )
        )
    }
    
}

@Composable
fun MyFloatingActionBotton() {
    FloatingActionButton(
        onClick = { }, containerColor = Color.Red,
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Floating Action Button")
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myDrawer(
    closeDrawer: () -> Unit = {}
) {
    ModalDrawerSheet(modifier = Modifier) {
        NavigationDrawerItem(
            label = {
                Text(
                    text = "LEXLE",
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = true,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )
        
        NavigationDrawerItem(
            label = { Text(text = "sdDasaSasaS", style = MaterialTheme.typography.labelSmall) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )
    }
}
package com.alx.learncompose


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    Scaffold( topBar = { MyTopAppBar() }) {
    
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
        TopAppBar(
            title = {
                Box(modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    Text(text = "Top App Bar", fontWeight = FontWeight.Bold)
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFF9F271C)
            ),
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back" )
                }
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Filled.Search , contentDescription = "Search")
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date")
                }
                
            }

        )
    }






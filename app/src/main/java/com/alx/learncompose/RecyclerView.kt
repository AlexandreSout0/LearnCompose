package com.alx.learncompose

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alx.learncompose.model.SuperHero


@Composable
fun RecycleView() {
    val myList = listOf("alex", "maria", "ana", "joão")
    LazyColumn {
        item { Text(text = "primeiro item") }
        items(7) { Text(text = "Este é o item $it") }
        
        items(myList) {
            Text(text = "Olá, $it")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHeros()) { it ->
            ItemHero(superHero = it){ superHero ->
                Toast.makeText(context,superHero.SuperHeroName, Toast.LENGTH_LONG).show()
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeros()) { it ->
            ItemHero(superHero = it){ superHero ->
                Toast.makeText(context,superHero.SuperHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected:(SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier.width(200.dp).clickable { onItemSelected(superHero) }.padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "Super Hero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.SuperHeroName, Modifier.align(Alignment.CenterHorizontally))
            Text(text = superHero.RealName, Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = superHero.publisher, Modifier.align(Alignment.End).padding(8.dp), fontSize = 10.sp )
        }
    }
}

fun getSuperHeros(): List<SuperHero> {
    return listOf(
        SuperHero("Spider-Ma", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Marvel", "James Howlett", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}
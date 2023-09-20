package com.alx.learncompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alx.learncompose.ui.theme.LearnComposeTheme
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    
        setContent {
            Timber.plant(Timber.DebugTree())
    
            LearnComposeTheme {
                HomeScreen()
            }
        }
        
    }
    
    
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    fun HomeScreen(
        modifier: Modifier = Modifier,
        onPlantClick: (Plant) -> Unit = {},
        viewModel: PlantListViewModel = hiltViewModel()
    ) {
        val pagerState = rememberPagerState()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        
        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                HomeTopAppBar(
                    pagerState = pagerState,
                    onFilterClick = { viewModel.updateData() },
                    scrollBehavior = scrollBehavior
                )
            }
        ) {
            HomePagerScreen(
                onPlantClick = onPlantClick,
                pagerState = pagerState,
                modifier = Modifier.padding(it)
            )
        }
    }
    
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun HomePagerScreen(
        onPlantClick: (Plant) -> Unit,
        pagerState: PagerState,
        modifier: Modifier = Modifier,
        pages: Array<SunflowerPage> = SunflowerPage.values()
    ) {
        // Use Modifier.nestedScroll + rememberNestedScrollInteropConnection() here so that this
        // composable participates in the nested scroll hierarchy so that HomeScreen can be used in
        // use cases like a collapsing toolbar
        Column(modifier) {
            val coroutineScope = rememberCoroutineScope()
            
            // Tab Row
            TabRow(
                selectedTabIndex = pagerState.currentPage
            ) {
                pages.forEachIndexed { index, page ->
                    val title = stringResource(id = page.titleResId)
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        text = { Text(text = title) },
                        icon = {
                            Icon(
                                painter = painterResource(id = page.drawableResId),
                                contentDescription = title
                            )
                        },
                        unselectedContentColor = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            
            // Pages
            HorizontalPager(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                pageCount = pages.size,
                state = pagerState,
                verticalAlignment = Alignment.Top
            ) { index ->
                when (pages[index]) {
                    SunflowerPage.MY_GARDEN -> {
                        GardenScreen(
                            Modifier.fillMaxSize(),
                            onAddPlantClick = {
                                coroutineScope.launch {
                                    pagerState.scrollToPage(SunflowerPage.PLANT_LIST.ordinal)
                                }
                            },
                            onPlantClick = {
                                onPlantClick(it.plant)
                            })
                    }
                    
                    SunflowerPage.PLANT_LIST -> {
                        PlantListScreen(
                            onPlantClick = onPlantClick,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
            }
        }
    }
    
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    private fun HomeTopAppBar(
        pagerState: PagerState,
        onFilterClick: () -> Unit,
        scrollBehavior: TopAppBarScrollBehavior,
        modifier: Modifier = Modifier
    ) {
        TopAppBar(
            title = {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            },
            modifier = modifier.statusBarsPadding(),
            actions = {
                if (pagerState.currentPage == SunflowerPage.PLANT_LIST.ordinal) {
                    IconButton(onClick = onFilterClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter_list_24dp),
                            contentDescription = stringResource(
                                id = R.string.menu_filter_by_grow_zone
                            )
                        )
                    }
                }
            },
            scrollBehavior = scrollBehavior
        )
    }
    
    @OptIn(ExperimentalFoundationApi::class)
    @Preview
    @Composable
    private fun HomeScreenPreview() {
        SunflowerTheme {
            HomePagerScreen(
                onPlantClick = {},
                pagerState = PagerState(),
            )
        }
    }



package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.screens.CategoryScreen
import com.example.ui.screens.DetailScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.RewardsScreen
import com.example.ui.theme.KidsLearningTheme
import com.example.utils.AdManager
import com.example.utils.TtsHelper
import com.example.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize AdMob & Interstitial ads
        AdManager.initialize(this)
        AdManager.loadInterstitial(this)

        setContent {
            KidsLearningTheme {
                KidsLearningApp()
            }
        }
    }
}

@Composable
fun KidsLearningApp(
    viewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val ttsHelper = remember { TtsHelper(context) }

    DisposableEffect(Unit) {
        onDispose {
            ttsHelper.shutdown()
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerState = drawerState,
                modifier = Modifier.width(310.dp),
                drawerContainerColor = Color(0xFFFFFAED)
            ) {
                // Cartoonistic Header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color(0xFFFF6B6B), Color(0xFFFF8400))
                            )
                        )
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("🦁🎈⭐🎨", fontSize = 32.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Kids Joy Land",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFFFFD93D)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("⭐ ${viewModel.totalStars} Reward Points ⭐", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF2D3436))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Navigation Items
                DrawerMenuItem(
                    iconEmoji = "🏠",
                    title = "Home / मुख्य पृष्ठ",
                    isSelected = false,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate("home") { popUpTo("home") { inclusive = true } }
                    }
                )

                DrawerMenuItem(
                    iconEmoji = "🎮",
                    title = "Play Fun Quiz / क्विज़",
                    isSelected = false,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate("quiz")
                    }
                )

                DrawerMenuItem(
                    iconEmoji = "🏆",
                    title = "Rewards & Badges / पुरस्कार",
                    isSelected = false,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navController.navigate("rewards")
                    }
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp))

                // Language Selector in Drawer
                Text(
                    text = "🌐 Select Language / भाषा चुनें:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF2D3436),
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                )

                DrawerMenuItem(
                    iconEmoji = "🇬🇧",
                    title = "English",
                    isSelected = viewModel.currentLang == "en",
                    onClick = {
                        viewModel.updateLanguage("en")
                        ttsHelper.speak("English mode selected", "en")
                        coroutineScope.launch { drawerState.close() }
                    }
                )

                DrawerMenuItem(
                    iconEmoji = "🇮🇳",
                    title = "हिंदी (Hindi)",
                    isSelected = viewModel.currentLang == "hi",
                    onClick = {
                        viewModel.updateLanguage("hi")
                        ttsHelper.speak("हिंदी मोड", "hi")
                        coroutineScope.launch { drawerState.close() }
                    }
                )

                DrawerMenuItem(
                    iconEmoji = "🇮🇳",
                    title = "मराठी (Marathi)",
                    isSelected = viewModel.currentLang == "mr",
                    onClick = {
                        viewModel.updateLanguage("mr")
                        ttsHelper.speak("मराठी मोड", "mr")
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    currentLang = viewModel.currentLang,
                    onLangChange = { viewModel.updateLanguage(it) },
                    onCategoryClick = { categoryId ->
                        navController.navigate("category/$categoryId")
                    },
                    onQuizClick = {
                        navController.navigate("quiz")
                    },
                    onRewardsClick = {
                        navController.navigate("rewards")
                    },
                    totalStars = viewModel.totalStars,
                    ttsHelper = ttsHelper,
                    onOpenDrawer = {
                        coroutineScope.launch { drawerState.open() }
                    }
                )
            }

            composable(
                route = "category/{categoryId}",
                arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
            ) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "alphabets_en"
                CategoryScreen(
                    categoryId = categoryId,
                    currentLang = viewModel.currentLang,
                    onBackClick = { navController.popBackStack() },
                    onItemClick = { item ->
                        navController.navigate("detail/${item.id}/$categoryId")
                    },
                    ttsHelper = ttsHelper
                )
            }

            composable(
                route = "detail/{itemId}/{categoryId}",
                arguments = listOf(
                    navArgument("itemId") { type = NavType.StringType },
                    navArgument("categoryId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
                val categoryId = backStackEntry.arguments?.getString("categoryId") ?: "alphabets_en"
                DetailScreen(
                    itemId = itemId,
                    categoryId = categoryId,
                    currentLang = viewModel.currentLang,
                    onBackClick = { navController.popBackStack() },
                    onAddStar = { viewModel.addStars(1) },
                    ttsHelper = ttsHelper
                )
            }

            composable("quiz") {
                QuizScreen(
                    currentLang = viewModel.currentLang,
                    onBackClick = { navController.popBackStack() },
                    onCorrectAnswer = { viewModel.addStars(5) },
                    ttsHelper = ttsHelper
                )
            }

            composable("rewards") {
                RewardsScreen(
                    totalStars = viewModel.totalStars,
                    currentLang = viewModel.currentLang,
                    onBackClick = { navController.popBackStack() },
                    ttsHelper = ttsHelper
                )
            }
        }
    }
}

@Composable
fun DrawerMenuItem(
    iconEmoji: String,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) Color(0xFFFF6B6B) else Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = iconEmoji, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Color(0xFF2D3436)
            )
        }
    }
}

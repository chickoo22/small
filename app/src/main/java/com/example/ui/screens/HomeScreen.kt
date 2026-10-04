package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Category
import com.example.data.KidsRepository
import com.example.ui.components.BannerAdView
import com.example.utils.TtsHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    currentLang: String,
    onLangChange: (String) -> Unit,
    onCategoryClick: (String) -> Unit,
    onQuizClick: () -> Unit,
    onRewardsClick: () -> Unit,
    totalStars: Int,
    ttsHelper: TtsHelper,
    onOpenDrawer: () -> Unit
) {
    val categories = KidsRepository.categories

    val title = when (currentLang) {
        "hi" -> "किड्स जॉय लर्निंग 🌟"
        "mr" -> "किड्स जॉय लर्निंग 🌟"
        else -> "Kids Joy Learning 🌟"
    }

    val subtitle = when (currentLang) {
        "hi" -> "खेल-खेल में सीखें ए-जेड, गिनती, रंग और बहुत कुछ!"
        "mr" -> "खेळता खेळता शिका अ-ज्ञ, अंक, रंग आणि बरेच काही!"
        else -> "Learn A-Z, Numbers, Shapes, Colors & More with Fun!"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF1E272E))
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color(0xFF1E272E))
                    }
                },
                actions = {
                    // Star Reward Points Counter with High Contrast
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(0xFFFFD93D),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable { onRewardsClick() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Star, contentDescription = "Stars", tint = Color(0xFFD63031), modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("$totalStars ⭐", fontWeight = FontWeight.ExtraBold, color = Color(0xFF1E272E))
                        }
                    }

                    IconButton(onClick = onRewardsClick) {
                        Icon(Icons.Default.EmojiEvents, contentDescription = "Rewards", tint = Color(0xFFE67E22))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFEAA7)
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onQuizClick,
                containerColor = Color(0xFFE74C3C),
                contentColor = Color.White,
                icon = { Icon(Icons.Default.VideogameAsset, contentDescription = "Quiz") },
                text = {
                    Text(
                        text = when(currentLang) {
                            "hi" -> "क्विज़ खेलें 🎮"
                            "mr" -> "क्विझ खेळा 🎮"
                            else -> "Play Quiz 🎮"
                        },
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFFFF3CD), Color(0xFFFFFFFF))
                    )
                )
                .padding(16.dp)
        ) {
            // Cartoonistic Welcome Banner with 5-Star Rating & High Contrast
            Card(
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0984E3)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = when(currentLang) {
                                "hi" -> "नमस्ते बच्चों! 👋"
                                "mr" -> "नमस्कार मुलांनो! 👋"
                                else -> "Hello Kids! 👋"
                            },
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
                        )
                        // 5 Star rating badge
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Color(0xFFFFD93D)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                repeat(5) {
                                    Icon(Icons.Default.Star, contentDescription = "5 Star", tint = Color(0xFFD63031), modifier = Modifier.size(14.dp))
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFFFFFFF)
                    )
                }
            }

            Text(
                text = when(currentLang) {
                    "hi" -> "📚 सीखने के लिए विषय चुनें:"
                    "mr" -> "📚 शिकण्यासाठी विषय निवडा:"
                    else -> "📚 Choose a Learning Topic:"
                },
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF2D3436),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Grid of categories with high contrast and bold readable text
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        currentLang = currentLang,
                        onClick = { onCategoryClick(category.id) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // AdMob Banner Ad View at bottom
            BannerAdView()
        }
    }
}

@Composable
fun CategoryCard(
    category: Category,
    currentLang: String,
    onClick: () -> Unit
) {
    val title = when (currentLang) {
        "hi" -> category.titleHi
        "mr" -> category.titleMr
        else -> category.titleEn
    }

    val color = when(category.id) {
        "alphabets_en" -> Color(0xFFD63031)
        "hindi_swar" -> Color(0xFF0984E3)
        "hindi_vyanjan" -> Color(0xFF00B894)
        "hindi_barakhadi" -> Color(0xFFF39C12)
        "marathi_swar" -> Color(0xFF8E44AD)
        "marathi_vyanjan" -> Color(0xFFE67E22)
        "marathi_barakhadi" -> Color(0xFF16A085)
        "numbers" -> Color(0xFFD35400)
        "shapes" -> Color(0xFF2980B9)
        "colors" -> Color(0xFFC0392B)
        "days" -> Color(0xFF27AE60)
        "english_months" -> Color(0xFF8E44AD)
        "indian_months" -> Color(0xFFD35400)
        "fruits_veg" -> Color(0xFF16A085)
        "animals_birds" -> Color(0xFFD63031)
        else -> Color(0xFF2980B9)
    }

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = category.iconEmoji, fontSize = 34.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                maxLines = 1,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

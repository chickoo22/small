package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.LearningItem
import com.example.data.room.KidsDatabaseRepository
import com.example.ui.components.BannerAdView
import com.example.ui.components.ConfettiExplosion
import com.example.utils.TtsHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    itemId: String,
    categoryId: String,
    currentLang: String,
    onBackClick: () -> Unit,
    onAddStar: () -> Unit,
    ttsHelper: TtsHelper
) {
    val context = LocalContext.current
    val repository = remember { KidsDatabaseRepository(context) }
    val items by repository.getItemsForCategory(categoryId).collectAsStateWithLifecycle(initialValue = emptyList())
    
    var currentIndex by remember(items, itemId) {
        mutableStateOf(items.indexOfFirst { it.id == itemId }.coerceAtLeast(0))
    }
    val currentItem = items.getOrNull(currentIndex) ?: LearningItem(itemId, "Loading...", "लोड हो रहा है...", "लोड होत आहे...", "Loading", "", "", "⭐", categoryId, "#FF6B6B")

    var confettiTrigger by remember { mutableStateOf(0) }

    LaunchedEffect(currentItem, currentLang) {
        if (currentItem.enText != "Loading...") {
            val textToSpeak = when (currentLang) {
                "hi" -> currentItem.hiText
                "mr" -> currentItem.mrText
                else -> currentItem.enText
            }
            ttsHelper.speak(textToSpeak, currentLang)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentItem.enText, fontWeight = FontWeight.Bold, color = Color(0xFF1E272E)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E272E))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        onAddStar()
                        confettiTrigger++
                        ttsHelper.speak("Star earned!", "en")
                    }) {
                        Icon(Icons.Default.Star, contentDescription = "Star", tint = Color(0xFFFFD93D))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFEAA7)
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFFFF3CD), Color(0xFFFFFFFF))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Giant Emoji Card
                    Card(
                        shape = RoundedCornerShape(36.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
                        modifier = Modifier
                            .size(240.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = currentItem.iconEmoji,
                                fontSize = 100.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Primary Language Text
                    Text(
                        text = when(currentLang) {
                            "hi" -> currentItem.hiText
                            "mr" -> currentItem.mrText
                            else -> currentItem.enText
                        },
                        fontSize = 36.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1E272E)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Multilingual details card
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F2F6)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("🇬🇧 English: ${currentItem.enText}", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D3436))
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("🇮🇳 हिंदी: ${currentItem.hiText}", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D3436))
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("🇮🇳 मराठी: ${currentItem.mrText}", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D3436))
                        }
                    }
                }

                // Banner Ad at bottom
                BannerAdView()
            }

            // Confetti Overlay
            ConfettiExplosion(trigger = confettiTrigger)
        }
    }
}

package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
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
import com.example.utils.TtsHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RewardsScreen(
    totalStars: Int,
    currentLang: String,
    onBackClick: () -> Unit,
    ttsHelper: TtsHelper
) {
    LaunchedEffect(Unit) {
        ttsHelper.speak("You have earned $totalStars stars. Amazing champion!", "en")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(when(currentLang) { "hi" -> "मेरे स्टार्स और ट्राफियां 🏆"; "mr" -> "माझे तारे आणि करंडक 🏆"; else -> "My Stars & Trophies 🏆" }, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFFFEECC), Color(0xFFFFF9F0))
                    )
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Trophy Banner Card
            Card(
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFD93D)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.EmojiEvents, contentDescription = "Trophy", tint = Color(0xFFFF6B6B), modifier = Modifier.size(64.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$totalStars Stars Earned!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D3436)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = when(currentLang) {
                            "hi" -> "आप बहुत अच्छे सीख रहे हैं!"
                            "mr" -> "तुम्ही खूप छान शिकत आहात!"
                            else -> "You are a Super Star Learner!"
                        },
                        fontSize = 16.sp,
                        color = Color(0xFF2D3436)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = when(currentLang) {
                    "hi" -> "🏅 अनलॉक की गई उपलब्धियाँ"
                    "mr" -> "🏅 अनलॉक केलेली वैशिष्ट्ये"
                    else -> "🏅 Unlocked Badges & Trophies"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3436),
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    BadgeItem("🔤", "Alphabet Champion", "Completed A-Z exploration", totalStars >= 5)
                }
                item {
                    BadgeItem("🔢", "Number Master", "Learned numbers 1 to 20", totalStars >= 10)
                }
                item {
                    BadgeItem("⭐", "Shape Wizard", "Mastered shapes & colors", totalStars >= 15)
                }
                item {
                    BadgeItem("🎮", "Quiz Star", "Scored high in fun quiz", totalStars >= 20)
                }
            }
        }
    }
}

@Composable
fun BadgeItem(emoji: String, title: String, subtitle: String, isUnlocked: Boolean) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = if (isUnlocked) Color.White else Color(0xFFE4E7EB)),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isUnlocked) 4.dp else 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = emoji, fontSize = 40.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isUnlocked) Color(0xFF2D3436) else Color(0xFF95A5A6)
                )
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color(0xFF636E72)
                )
            }
            if (isUnlocked) {
                Icon(Icons.Default.Star, contentDescription = "Unlocked", tint = Color(0xFFFFD93D))
            } else {
                Text("🔒", fontSize = 24.sp)
            }
        }
    }
}

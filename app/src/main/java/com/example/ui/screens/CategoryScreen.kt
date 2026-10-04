package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.VolumeUp
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.KidsRepository
import com.example.data.LearningItem
import com.example.data.room.KidsDatabaseRepository
import com.example.ui.components.BannerAdView
import com.example.utils.TtsHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    categoryId: String,
    currentLang: String,
    onBackClick: () -> Unit,
    onItemClick: (LearningItem) -> Unit,
    ttsHelper: TtsHelper
) {
    val context = LocalContext.current
    val repository = remember { KidsDatabaseRepository(context) }
    val items by repository.getItemsForCategory(categoryId).collectAsStateWithLifecycle(initialValue = emptyList())

    val categoryObj = remember(categoryId) {
        KidsRepository.categories.find { it.id == categoryId }
    }

    val categoryTitle = categoryObj?.let {
        when(currentLang) {
            "hi" -> it.titleHi
            "mr" -> it.titleMr
            else -> it.titleEn
        }
    } ?: "Learning"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(categoryTitle, fontWeight = FontWeight.Bold, color = Color(0xFF1E272E)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E272E))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFEAA7)
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
                        listOf(Color(0xFFFFF3CD), Color(0xFFFFFFFF))
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(items) { item ->
                    LearningItemCard(
                        item = item,
                        currentLang = currentLang,
                        onClick = { onItemClick(item) },
                        onSpeakerClick = {
                            val textToSpeak = when (currentLang) {
                                "hi" -> item.hiText
                                "mr" -> item.mrText
                                else -> item.enText
                            }
                            ttsHelper.speak(textToSpeak, currentLang)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            BannerAdView()
        }
    }
}

@Composable
fun LearningItemCard(
    item: LearningItem,
    currentLang: String,
    onClick: () -> Unit,
    onSpeakerClick: () -> Unit
) {
    val mainText = when (currentLang) {
        "hi" -> item.hiText
        "mr" -> item.mrText
        else -> item.enText
    }

    val subText = when (currentLang) {
        "hi" -> item.subTextHi
        "mr" -> item.subTextMr
        else -> item.subTextEn
    }

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            IconButton(
                onClick = onSpeakerClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(32.dp)
            ) {
                Icon(
                    Icons.Default.VolumeUp,
                    contentDescription = "Speak",
                    tint = Color(0xFF0984E3)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = item.iconEmoji, fontSize = 38.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = mainText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1E272E)
                )
                if (subText.isNotEmpty()) {
                    Text(
                        text = subText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF636E72),
                        maxLines = 1
                    )
                }
            }
        }
    }
}

package com.example.data

data class LearningItem(
    val id: String,
    val enText: String,
    val hiText: String,
    val mrText: String,
    val subTextEn: String = "",
    val subTextHi: String = "",
    val subTextMr: String = "",
    val iconEmoji: String,
    val category: String,
    val colorHex: String = "#FF6B6B"
)

data class Category(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val titleMr: String,
    val iconEmoji: String,
    val backgroundColor: String
)

package com.example.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.LearningItem

@Entity(tableName = "learning_items")
data class LearningItemEntity(
    @PrimaryKey val id: String,
    val categoryId: String,
    val enText: String,
    val hiText: String,
    val mrText: String,
    val iconEmoji: String,
    val subTextEn: String,
    val subTextHi: String,
    val subTextMr: String
) {
    fun toLearningItem(): LearningItem {
        return LearningItem(
            id = id,
            enText = enText,
            hiText = hiText,
            mrText = mrText,
            subTextEn = subTextEn,
            subTextHi = subTextHi,
            subTextMr = subTextMr,
            iconEmoji = iconEmoji,
            category = categoryId,
            colorHex = "#FF6B6B"
        )
    }

    companion object {
        fun fromLearningItem(item: LearningItem, categoryId: String): LearningItemEntity {
            return LearningItemEntity(
                id = item.id,
                categoryId = categoryId,
                enText = item.enText,
                hiText = item.hiText,
                mrText = item.mrText,
                iconEmoji = item.iconEmoji,
                subTextEn = item.subTextEn,
                subTextHi = item.subTextHi,
                subTextMr = item.subTextMr
            )
        }
    }
}

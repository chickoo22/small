package com.example.data.room

import android.content.Context
import com.example.data.KidsRepository
import com.example.data.LearningItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class KidsDatabaseRepository(context: Context) {
    private val dao = AppDatabase.getDatabase(context).learningItemDao()

    suspend fun initializeCacheIfNeeded() {
        withContext(Dispatchers.IO) {
            if (dao.getCount() == 0) {
                val allEntities = mutableListOf<LearningItemEntity>()
                val categoryMap = mapOf(
                    "alphabets_en" to KidsRepository.englishAlphabets,
                    "hindi_swar" to KidsRepository.hindiSwar,
                    "hindi_vyanjan" to KidsRepository.hindiVyanjan,
                    "hindi_barakhadi" to KidsRepository.hindiBarakhadi,
                    "marathi_swar" to KidsRepository.marathiSwar,
                    "marathi_vyanjan" to KidsRepository.marathiVyanjan,
                    "marathi_barakhadi" to KidsRepository.marathiBarakhadi,
                    "numbers" to KidsRepository.numbers,
                    "shapes" to KidsRepository.shapes,
                    "colors" to KidsRepository.colors,
                    "days" to KidsRepository.daysOfWeek,
                    "english_months" to KidsRepository.englishMonths,
                    "indian_months" to KidsRepository.indianMonths,
                    "fruits_veg" to KidsRepository.fruitsVeg,
                    "animals_birds" to KidsRepository.animalsBirds,
                    "vehicles" to KidsRepository.vehicles
                )

                for ((catId, items) in categoryMap) {
                    for (item in items) {
                        allEntities.add(LearningItemEntity.fromLearningItem(item, catId))
                    }
                }
                dao.insertAll(allEntities)
            }
        }
    }

    fun getItemsForCategory(categoryId: String): Flow<List<LearningItem>> {
        return dao.getItemsForCategory(categoryId).map { entities ->
            entities.map { it.toLearningItem() }
        }
    }
}

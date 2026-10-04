package com.example.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TtsHelper(context: Context, private val onInitialized: () -> Unit = {}) {
    private var tts: TextToSpeech? = null
    private var isReady = false

    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isReady = true
                tts?.language = Locale.ENGLISH
                onInitialized()
            } else {
                Log.e("TtsHelper", "Initialization failed")
            }
        }
    }

    fun speak(text: String, languageCode: String = "en") {
        if (!isReady || tts == null) return
        val locale = when (languageCode) {
            "hi" -> Locale("hi", "IN")
            "mr" -> Locale("mr", "IN")
            else -> Locale.ENGLISH
        }
        try {
            val availability = tts?.isLanguageAvailable(locale)
            if (availability == TextToSpeech.LANG_AVAILABLE || 
                availability == TextToSpeech.LANG_COUNTRY_AVAILABLE || 
                availability == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE) {
                tts?.language = locale
            } else {
                tts?.language = Locale.ENGLISH
            }
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } catch (e: Exception) {
            Log.e("TtsHelper", "Error speaking text: ${e.message}")
        }
    }

    fun shutdown() {
        try {
            tts?.stop()
            tts?.shutdown()
        } catch (e: Exception) {
            Log.e("TtsHelper", "Error shutting down TTS", e)
        }
    }
}

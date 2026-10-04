package com.example.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object AdManager {
    private var interstitialAd: InterstitialAd? = null
    private var isInitialized = false

    fun initialize(context: Context) {
        if (isInitialized) return
        try {
            MobileAds.initialize(context) { initializationStatus ->
                isInitialized = true
                Log.d("AdManager", "AdMob initialized successfully: $initializationStatus")
            }
            // Set child-directed treatment for Google Play Families Policy compliance (COPPA)
            val configuration = RequestConfiguration.Builder()
                .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build()
            MobileAds.setRequestConfiguration(configuration)
        } catch (e: Exception) {
            Log.e("AdManager", "Error initializing AdMob", e)
        }
    }

    fun loadInterstitial(context: Context) {
        // Test interstitial ad unit ID
        val adUnitId = "ca-app-pub-3940256099942544/1033173712"
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(context, adUnitId, adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(ad: InterstitialAd) {
                interstitialAd = ad
                Log.d("AdManager", "Interstitial ad loaded successfully")
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                interstitialAd = null
                Log.d("AdManager", "Interstitial ad failed to load: ${adError.message}")
            }
        })
    }

    fun showInterstitial(context: android.app.Activity, onAdDismissed: () -> Unit = {}) {
        if (interstitialAd != null) {
            interstitialAd?.fullScreenContentCallback = object : com.google.android.gms.ads.FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    interstitialAd = null
                    loadInterstitial(context)
                    onAdDismissed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                    interstitialAd = null
                    onAdDismissed()
                }
            }
            interstitialAd?.show(context)
        } else {
            onAdDismissed()
            loadInterstitial(context)
        }
    }
}

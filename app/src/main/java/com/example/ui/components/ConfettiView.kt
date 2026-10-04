package com.example.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import kotlin.random.Random
import kotlin.math.cos
import kotlin.math.sin

data class Particle(
    var x: Float,
    var y: Float,
    var vx: Float,
    var vy: Float,
    val color: Color,
    val size: Float,
    var rotation: Float,
    val vRotation: Float
)

@Composable
fun ConfettiExplosion(
    trigger: Int,
    onFinished: () -> Unit = {}
) {
    if (trigger == 0) return

    val particles = remember(trigger) {
        val colors = listOf(
            Color(0xFFFFD93D),
            Color(0xFFFF6B6B),
            Color(0xFF4D96FF),
            Color(0xFF6BCB77),
            Color(0xFF9370DB),
            Color(0xFFFF8400)
        )
        List(60) {
            val angle = Random.nextFloat() * Math.PI.toFloat() * 2f
            val speed = Random.nextFloat() * 20f + 6f
            Particle(
                x = 0f,
                y = 0f,
                vx = cos(angle) * speed,
                vy = sin(angle) * speed - 10f,
                color = colors.random(),
                size = Random.nextFloat() * 24f + 12f,
                rotation = Random.nextFloat() * 360f,
                vRotation = Random.nextFloat() * 20f - 10f
            )
        }
    }

    val animProgress = remember { Animatable(0f) }

    LaunchedEffect(trigger) {
        animProgress.snapTo(0f)
        animProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2500, easing = FastOutSlowInEasing)
        )
        onFinished()
    }

    if (animProgress.isRunning) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val centerX = width / 2f
            val centerY = height / 3f

            val progress = animProgress.value
            particles.forEach { p ->
                val px = centerX + p.vx * progress * 45f
                val py = centerY + p.vy * progress * 45f + (progress * progress * 700f) // gravity
                val pAlpha = (1f - progress).coerceIn(0f, 1f)
                val currentRotation = p.rotation + p.vRotation * progress * 60f

                rotate(currentRotation, pivot = Offset(px, py)) {
                    drawRect(
                        color = p.color.copy(alpha = pAlpha),
                        topLeft = Offset(px - p.size / 2f, py - p.size / 2f),
                        size = androidx.compose.ui.geometry.Size(p.size, p.size * 0.6f)
                    )
                }
            }
        }
    }
}

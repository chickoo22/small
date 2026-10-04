package com.example.ui.screens

import androidx.compose.animation.core.*
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.KidsRepository
import com.example.data.LearningItem
import com.example.ui.components.ConfettiExplosion
import com.example.utils.TtsHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    currentLang: String,
    onBackClick: () -> Unit,
    onCorrectAnswer: () -> Unit,
    ttsHelper: TtsHelper
) {
    val coroutineScope = rememberCoroutineScope()
    val pool: List<LearningItem> = remember {
        (KidsRepository.englishAlphabets + KidsRepository.numbers + KidsRepository.fruitsVeg + KidsRepository.animalsBirds).shuffled()
    }

    var questionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var feedbackMessage by remember { mutableStateOf("") }
    var isAnswered by remember { mutableStateOf(false) }
    var selectedItemId by remember { mutableStateOf<String?>(null) }
    var confettiTrigger by remember { mutableStateOf(0) }

    val currentTarget = if (pool.isNotEmpty()) pool[questionIndex % pool.size] else KidsRepository.englishAlphabets.first()

    val options: List<LearningItem> = remember(questionIndex) {
        val others = pool.filter { it.id != currentTarget.id }.shuffled().take(3)
        (others + currentTarget).shuffled()
    }

    val targetText = when (currentLang) {
        "hi" -> currentTarget.hiText
        "mr" -> currentTarget.mrText
        else -> currentTarget.enText
    }

    LaunchedEffect(questionIndex) {
        val qPrompt = when (currentLang) {
            "hi" -> "ढूँढो: $targetText कहाँ है?"
            "mr" -> "शोधा: $targetText कुठे आहे?"
            else -> "Find: Where is $targetText?"
        }
        ttsHelper.speak(qPrompt, currentLang)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(when(currentLang) { "hi" -> "मजेदार क्विज़ 🎮"; "mr" -> "मजेदार क्विझ 🎮"; else -> "Fun Quiz 🎮" }, fontWeight = FontWeight.Bold, color = Color(0xFF1E272E)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E272E))
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier.padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Star, contentDescription = "Score", tint = Color(0xFFFFD93D))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Score: $score", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, color = Color(0xFF1E272E))
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
                )
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Question Banner with Pulse Animation
                val infiniteTransition = rememberInfiniteTransition(label = "question_pulse")
                val bannerScale by infiniteTransition.animateFloat(
                    initialValue = 1f,
                    targetValue = 1.03f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(800, easing = FastOutSlowInEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "banner_scale"
                )

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0984E3)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .scale(bannerScale)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = when(currentLang) {
                                "hi" -> "इसे पहचानें:"
                                "mr" -> "हे ओळखा:"
                                else -> "Tap the correct item:"
                            },
                            fontSize = 16.sp,
                            color = Color(0xFFF1F2F6),
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = targetText,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                // Feedback banner
                if (feedbackMessage.isNotEmpty()) {
                    Text(
                        text = feedbackMessage,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = if (feedbackMessage.contains("🎉") || feedbackMessage.contains("शाबाश")) Color(0xFF27AE60) else Color(0xFFEB4D4B)
                    )
                }

                // Options Grid (2x2) with bouncy animation
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val opt0 = options.getOrNull(0)
                        val opt1 = options.getOrNull(1)
                        if (opt0 != null) {
                            Box(modifier = Modifier.weight(1f)) {
                                QuizOptionCard(
                                    item = opt0,
                                    currentLang = currentLang,
                                    isSelected = selectedItemId == opt0.id,
                                    isCorrectAnswer = isAnswered && opt0.id == currentTarget.id,
                                    onClick = {
                                        if (!isAnswered) {
                                            selectedItemId = opt0.id
                                            isAnswered = true
                                            val isCorrect = opt0.id == currentTarget.id
                                            if (isCorrect) confettiTrigger++
                                            handleQuizAnswer(opt0, currentTarget, currentLang, ttsHelper, coroutineScope, { score += 10; onCorrectAnswer() }, { msg -> feedbackMessage = msg }, { isAnswered = false; selectedItemId = null }) { questionIndex++ }
                                        }
                                    }
                                )
                            }
                        }
                        if (opt1 != null) {
                            Box(modifier = Modifier.weight(1f)) {
                                QuizOptionCard(
                                    item = opt1,
                                    currentLang = currentLang,
                                    isSelected = selectedItemId == opt1.id,
                                    isCorrectAnswer = isAnswered && opt1.id == currentTarget.id,
                                    onClick = {
                                        if (!isAnswered) {
                                            selectedItemId = opt1.id
                                            isAnswered = true
                                            val isCorrect = opt1.id == currentTarget.id
                                            if (isCorrect) confettiTrigger++
                                            handleQuizAnswer(opt1, currentTarget, currentLang, ttsHelper, coroutineScope, { score += 10; onCorrectAnswer() }, { msg -> feedbackMessage = msg }, { isAnswered = false; selectedItemId = null }) { questionIndex++ }
                                        }
                                    }
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val opt2 = options.getOrNull(2)
                        val opt3 = options.getOrNull(3)
                        if (opt2 != null) {
                            Box(modifier = Modifier.weight(1f)) {
                                QuizOptionCard(
                                    item = opt2,
                                    currentLang = currentLang,
                                    isSelected = selectedItemId == opt2.id,
                                    isCorrectAnswer = isAnswered && opt2.id == currentTarget.id,
                                    onClick = {
                                        if (!isAnswered) {
                                            selectedItemId = opt2.id
                                            isAnswered = true
                                            val isCorrect = opt2.id == currentTarget.id
                                            if (isCorrect) confettiTrigger++
                                            handleQuizAnswer(opt2, currentTarget, currentLang, ttsHelper, coroutineScope, { score += 10; onCorrectAnswer() }, { msg -> feedbackMessage = msg }, { isAnswered = false; selectedItemId = null }) { questionIndex++ }
                                        }
                                    }
                                )
                            }
                        }
                        if (opt3 != null) {
                            Box(modifier = Modifier.weight(1f)) {
                                QuizOptionCard(
                                    item = opt3,
                                    currentLang = currentLang,
                                    isSelected = selectedItemId == opt3.id,
                                    isCorrectAnswer = isAnswered && opt3.id == currentTarget.id,
                                    onClick = {
                                        if (!isAnswered) {
                                            selectedItemId = opt3.id
                                            isAnswered = true
                                            val isCorrect = opt3.id == currentTarget.id
                                            if (isCorrect) confettiTrigger++
                                            handleQuizAnswer(opt3, currentTarget, currentLang, ttsHelper, coroutineScope, { score += 10; onCorrectAnswer() }, { msg -> feedbackMessage = msg }, { isAnswered = false; selectedItemId = null }) { questionIndex++ }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Confetti Overlay
            ConfettiExplosion(trigger = confettiTrigger)
        }
    }
}

private fun handleQuizAnswer(
    selected: LearningItem,
    target: LearningItem,
    currentLang: String,
    ttsHelper: TtsHelper,
    scope: kotlinx.coroutines.CoroutineScope,
    onAddScore: () -> Unit,
    setFeedback: (String) -> Unit,
    resetState: () -> Unit,
    nextQuestion: () -> Unit
) {
    if (selected.id == target.id) {
        onAddScore()
        setFeedback(
            when (currentLang) {
                "hi" -> "🎉 बिल्कुल सही! शाबाश!"
                "mr" -> "🎉 अगदी बरोबर! शाब्बास!"
                else -> "🎉 Correct! Great job!"
            }
        )
        ttsHelper.speak("Correct! Awesome!", "en")
    } else {
        setFeedback(
            when (currentLang) {
                "hi" -> "❌ फिर से प्रयास करें!"
                "mr" -> "❌ पुन्हा प्रयत्न करा!"
                else -> "❌ Try again!"
            }
        )
        ttsHelper.speak("Try again", "en")
    }
    scope.launch {
        delay(1400)
        setFeedback("")
        resetState()
        nextQuestion()
    }
}

@Composable
fun QuizOptionCard(
    item: LearningItem,
    currentLang: String,
    isSelected: Boolean,
    isCorrectAnswer: Boolean,
    onClick: () -> Unit
) {
    val text = when (currentLang) {
        "hi" -> item.hiText
        "mr" -> item.mrText
        else -> item.enText
    }

    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.12f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "card_scale"
    )

    val cardColor = when {
        isCorrectAnswer -> Color(0xFFE8F8F5)
        isSelected -> Color(0xFFFFEEEE)
        else -> Color.White
    }

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 10.dp else 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .scale(scale)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = item.iconEmoji, fontSize = 40.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2D3436))
        }
    }
}

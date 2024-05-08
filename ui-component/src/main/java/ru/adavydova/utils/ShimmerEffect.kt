package ru.adavydova.utils

import android.annotation.SuppressLint
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import ru.adavydova.ui_component.R

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.shimmerLoadingAnimation(): Modifier {
    return composed {
        val transition = rememberInfiniteTransition(label = "")
        val alpha = transition.animateFloat(
            initialValue = 0.6f,
            targetValue = 0.9f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        ).value
        background(color = ColorUI.welcomeColor.copy(alpha))
    }
}
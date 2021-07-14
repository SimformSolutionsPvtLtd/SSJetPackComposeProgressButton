package com.simform.ssloadingbuttonandroid.ssbutton

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

object Animation {
    @Composable
    fun ssRepeatedFloatAnimation(
        initialValue: Float,
        targetValue: Float,
        durationMillis: Int
    ): Float {
        val repeatedFloat by rememberInfiniteTransition().animateValue(
            initialValue = initialValue,
            targetValue = targetValue,
            typeConverter = Float.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        return repeatedFloat
    }
    @Composable
    fun ssRepeatedDpAnimation(initialValue: Dp, targetValue: Dp, durationMillis: Int): Dp {
        val repeatedDp by rememberInfiniteTransition().animateValue(
            initialValue = initialValue,
            targetValue = targetValue,
            typeConverter = Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        return repeatedDp
    }
    @Composable
    fun ssRepeatedColorAnimation(initialValue: Color, targetValue: Color, durationMillis: Int): Color {
        val repeatedColor by  rememberInfiniteTransition().animateColor(
            initialValue = initialValue,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        return repeatedColor
    }
    @Composable
    fun sizeAnimationMethod(targetValue: Dp, durationMillis: Int): Dp {
        val size by animateDpAsState(
            targetValue = targetValue,
            tween(
                durationMillis = durationMillis,
                easing = LinearOutSlowInEasing
            )
        )
        return size
    }
    @Composable
    fun ssAnimateIntAsState(targetValue: Int, durationMillis: Int): Int {
        val newValue by animateIntAsState(targetValue, animationSpec = tween(durationMillis))
        return newValue
    }
    @Composable
    fun ssAnimateFloatAsState(targetValue: Float, durationMillis: Int): Float {
        val newValue by animateFloatAsState(targetValue, animationSpec = tween(durationMillis))
        return newValue
    }
}
package com.simform.ssloadingbuttonandroid.ui.theme

import androidx.compose.animation.core.*
import androidx.compose.runtime.getValue
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.ui.theme.SSLoadingButtonAndroidTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.delay
import java.lang.Math.cos
import kotlin.math.cos


 object AnimationUtils {

    @Composable
    fun progressRotationMethod(initialValue: Float, targetValue: Float, durationMillis: Int): Float {
        val progressRotation by rememberInfiniteTransition().animateValue(
            initialValue = initialValue,
            targetValue = targetValue,
            typeConverter = Float.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        return progressRotation
    }

     @Composable
     fun progressDpMethod(initialValue: Dp, targetValue: Dp, durationMillis: Int): Dp {
         val progressRotation by rememberInfiniteTransition().animateValue(
             initialValue = initialValue,
             targetValue = targetValue,
             typeConverter = Dp.VectorConverter,
             animationSpec = infiniteRepeatable(
                 animation = tween(durationMillis, easing = LinearEasing),
                 repeatMode = RepeatMode.Reverse
             )
         )
         return progressRotation
     }
     
     @Composable
     fun sizeAnimationMethod(width: Dp, durationMillis: Int): Dp {
         val size by animateDpAsState(
             targetValue = width,
             tween(
                 durationMillis = 2000,
                 delayMillis = 300,
                 easing = LinearOutSlowInEasing
             )
         )
         return size
     }

}
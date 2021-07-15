package com.simform.ssloadingbuttonandroid.ssbutton

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.R
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedDpAnimation
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedFloatAnimation
import com.simform.ssloadingbuttonandroid.ssbutton.ClockLoadingBar.Clock
import com.simform.ssloadingbuttonandroid.utils.ten
import com.simform.ssloadingbuttonandroid.utils.three
import com.simform.ssloadingbuttonandroid.utils.threeSixtyFloat
import com.simform.ssloadingbuttonandroid.utils.zeroFloat

object PrintLoadingBar {
    @Composable
    fun printLoadingBar(
        type: SSButtonType,
        progressAlpha: Float,
        assetColor: Color,
        minHeightWidth: Dp,
        durationMillis: Int,
        hourHandColor: Color
    ) {
        when (type) {
            SSButtonType.ROUNDED_PROGRESS -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .graphicsLayer(alpha = progressAlpha)
                        .size(minHeightWidth - ten.dp),
                    color = assetColor,
                    strokeWidth = three.dp
                )
            }
            SSButtonType.WHEEL -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(minHeightWidth - ten.dp)
                        .graphicsLayer { alpha = progressAlpha }
                        .rotate(
                            ssRepeatedFloatAnimation(
                                zeroFloat,
                                threeSixtyFloat,
                                durationMillis
                            )
                        ),
                    tint = assetColor
                )
            }
            SSButtonType.ZOOM_IN_OUT_PROGRESS -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .graphicsLayer(alpha = progressAlpha)
                        .size(
                            ssRepeatedDpAnimation(
                                initialValue = minHeightWidth - ten.dp,
                                targetValue = ten.dp,
                                durationMillis = durationMillis
                            )
                        ),
                    color = assetColor,
                    strokeWidth = three.dp
                )
            }
            SSButtonType.CLOCK -> {
                Clock(
                    modifier = Modifier
                        .graphicsLayer { alpha = progressAlpha },
                    minuteColor = assetColor,
                    minHeightWidth = minHeightWidth,
                    hourColor = hourHandColor
                )
            }
            SSButtonType.SPIRAL -> {
                Icon(
                    painter = painterResource(id = R.drawable.spiral),
                    contentDescription = null,
                    modifier = Modifier
                        .size(minHeightWidth - ten.dp)
                        .graphicsLayer { alpha = progressAlpha }
                        .rotate(
                            ssRepeatedFloatAnimation(
                                initialValue = threeSixtyFloat,
                                targetValue = zeroFloat,
                                durationMillis = durationMillis
                            )
                        ),
                    tint = assetColor
                )
            }
        }
    }
}
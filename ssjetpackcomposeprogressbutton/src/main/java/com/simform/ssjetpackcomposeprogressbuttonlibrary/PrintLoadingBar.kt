package com.simform.ssjetpackcomposeprogressbuttonlibrary

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ZERO
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ten
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.three
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.threeSixtyFloat
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.zeroFloat

@Composable
fun PrintLoadingBar(
    type: SSButtonType,
    progressAlpha: Float,
    assetColor: Color,
    minHeightWidth: Dp,
    durationMillis: Int,
    hourHandColor: Color,
    customLoadingIconPainter: Painter,
    customLoadingEffect: SSCustomLoadingEffect,
    customLoadingPadding: Int = ZERO
) {
    when (type) {
        SSButtonType.CIRCLE -> {
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
                painter = painterResource(id = R.drawable.wheel),
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
        SSButtonType.ZOOM_IN_OUT_CIRCLE -> {
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
            ClockLoadingBar(
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
        SSButtonType.CUSTOM -> {
            val customColor = ssRepeatedColorAnimation(
                assetColor, if (customLoadingEffect.colorChanger) {
                    Color.White
                } else {
                    assetColor
                }, durationMillis
            )
            val customRotation = ssRepeatedFloatAnimation(
                initialValue = if (customLoadingEffect.rotation) {
                    threeSixtyFloat
                } else {
                    zeroFloat
                },
                targetValue = zeroFloat,
                durationMillis = durationMillis
            )

            val customSize = ssRepeatedDpAnimation(
                initialValue = minHeightWidth - customLoadingPadding.dp,
                targetValue = if (customLoadingEffect.zoomInOut) {
                    ten.dp
                } else {
                    minHeightWidth - customLoadingPadding.dp
                },
                durationMillis = durationMillis
            )
            Icon(
                painter = customLoadingIconPainter,
                contentDescription = null,
                modifier = Modifier
                    .size(customSize)
                    .graphicsLayer { alpha = progressAlpha }
                    .rotate(customRotation),
                tint = customColor
            )
        }

    }
}
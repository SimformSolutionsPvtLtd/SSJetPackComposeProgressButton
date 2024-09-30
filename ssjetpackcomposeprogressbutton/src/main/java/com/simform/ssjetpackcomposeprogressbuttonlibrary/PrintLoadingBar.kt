package com.simform.ssjetpackcomposeprogressbuttonlibrary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ANIMATION_INITIAL_ZERO
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.DISABLE_VIEW_ALPHA
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.BORDER_MEDIUM
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.BORDER_SMALL
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ENABLE_VIEW_ALPHA
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ROTATE_THREE_SIXTY_DEGREE

@Composable
fun PrintLoadingBar(
    type: SSButtonType,
    progressAlpha: Float,
    assetColor: Color,
    minHeightWidth: Dp,
    durationMillis: Int,
    hourHandColor: Color,
    customLoadingIconPainter: Painter?,
    customLoadingEffect: SSCustomLoadingEffect,
    customLoadingPadding: Int = 0
) {
    when (type) {
        SSButtonType.CIRCLE -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .graphicsLayer(alpha = progressAlpha)
                    .size(minHeightWidth - SPACING_SMALL),
                color = assetColor,
                strokeWidth = BORDER_MEDIUM
            )
        }
        SSButtonType.WHEEL -> {
            Icon(
                painter = painterResource(id = R.drawable.wheel),
                contentDescription = null,
                modifier = Modifier
                    .size(minHeightWidth - SPACING_SMALL)
                    .graphicsLayer { alpha = progressAlpha }
                    .rotate(
                        ssRepeatedFloatAnimation(
                            ANIMATION_INITIAL_ZERO,
                            ROTATE_THREE_SIXTY_DEGREE,
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
                            initialValue = minHeightWidth - SPACING_SMALL,
                            targetValue = SPACING_SMALL,
                            durationMillis = durationMillis
                        )
                    ),
                color = assetColor,
                strokeWidth = BORDER_SMALL
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
                    .size(minHeightWidth - SPACING_SMALL)
                    .graphicsLayer { alpha = progressAlpha }
                    .rotate(
                        ssRepeatedFloatAnimation(
                            initialValue = ROTATE_THREE_SIXTY_DEGREE,
                            targetValue = ANIMATION_INITIAL_ZERO,
                            durationMillis = durationMillis
                        )
                    ),
                tint = assetColor
            )
        }
        SSButtonType.CUSTOM -> {
            val customAlpha = ssRepeatedFloatAnimation(
                ENABLE_VIEW_ALPHA, DISABLE_VIEW_ALPHA, durationMillis
            )
            val customRotation = ssRepeatedFloatAnimation(
                initialValue = if (customLoadingEffect.rotation) {
                    ROTATE_THREE_SIXTY_DEGREE
                } else {
                    ANIMATION_INITIAL_ZERO
                },
                targetValue = ANIMATION_INITIAL_ZERO,
                durationMillis = durationMillis
            )

            val customSize = ssRepeatedDpAnimation(
                initialValue = minHeightWidth - customLoadingPadding.dp,
                targetValue = if (customLoadingEffect.zoomInOut) {
                    SPACING_SMALL
                } else {
                    minHeightWidth - customLoadingPadding.dp
                },
                durationMillis = durationMillis
            )
            customLoadingIconPainter?.let {
                Image(
                    painter = customLoadingIconPainter,
                    contentDescription = "",
                    modifier = Modifier
                        .size(customSize)
                        .graphicsLayer { alpha = progressAlpha }
                        .rotate(customRotation)
                        .clip(CircleShape)
                        .alpha(if (customLoadingEffect.fadeInOut) customAlpha else ENABLE_VIEW_ALPHA),
                )
            }
        }
    }
}
package com.simform.ssjetpackcomposeprogressbuttonlibrary

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.SPACING_MEDIUM
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.HOUR_DURATION
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.MINUTE_DURATION
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ANIMATION_TARGET_ONE
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ROTATE_THREE_SIXTY_DEGREE
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ANIMATION_INITIAL_ZERO
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.BORDER_LARGE

@Composable
fun ClockLoadingBar(
    modifier: Modifier = Modifier,
    minuteColor: Color,
    hourColor: Color,
    minHeightWidth: Dp
) {
    val progressRotation = ssRepeatedFloatAnimation(
        initialValue = ANIMATION_INITIAL_ZERO,
        targetValue = ANIMATION_TARGET_ONE,
        durationMillis = MINUTE_DURATION
    )
    val progressHourRotation = ssRepeatedFloatAnimation(
        initialValue = ANIMATION_INITIAL_ZERO,
        targetValue = ANIMATION_TARGET_ONE,
        durationMillis = HOUR_DURATION
    )
    Canvas(modifier = modifier) {
        val middle = Offset(size.minDimension / 2, size.minDimension / 2)
        withTransform(
            {
                rotate(ROTATE_THREE_SIXTY_DEGREE * progressRotation, middle)
            }, {
                drawLine(
                    strokeWidth = BORDER_LARGE.toPx(),
                    cap = StrokeCap.Round,
                    color = minuteColor,
                    start = middle,
                    end = Offset(
                        size.minDimension / 2,
                        (minHeightWidth / 2 - SPACING_SMALL).toPx()
                    )
                )
            }
        )
        withTransform(
            {
                rotate(ROTATE_THREE_SIXTY_DEGREE * progressHourRotation, middle)
            }, {
                drawLine(
                    strokeWidth = BORDER_LARGE.toPx(),
                    cap = StrokeCap.Round,
                    color = hourColor,
                    start = middle,
                    end = Offset(
                        size.minDimension / 2,
                        (minHeightWidth / 2 - SPACING_MEDIUM).toPx()
                    )
                )
            }
        )
    }
}
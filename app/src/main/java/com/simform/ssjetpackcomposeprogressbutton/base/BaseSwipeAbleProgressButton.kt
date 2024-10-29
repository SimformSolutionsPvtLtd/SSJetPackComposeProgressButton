package com.simform.ssjetpackcomposeprogressbutton.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.simform.ssjetpackcomposeprogressbutton.R
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.EXTRA_SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_NORMAL
import com.simform.ssjetpackcomposeprogressbutton.utils.LIGHT_PINK
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSJetPackComposeProgressButton

/**
 * A composable function to create a customizable swipeable progress button with support for animations,
 * icons, and swipe actions. This button allows users to perform swipe gestures for confirmation or
 * progress.
 */
@Composable
fun BaseSwipeAbleProgressButton(
    type: SSButtonType,
    assetColor: Color = LIGHT_PINK,
    containerColor: Color = Color.White,
    disabledContainerColor: Color = Color.White,
    buttonBorderWidth: Dp = Dimensions.COMMON_BORDER_WIDTH,
    animatedButtonBorderColor: Color = LIGHT_PINK,
    buttonBorderColor: Color = LIGHT_PINK,
    onClick: () -> Unit,
    buttonState: SSButtonState,
    width: Dp = Dimensions.COMMON_WIDTH,
    height: Dp = Dimensions.COMMON_HEIGHT,
    padding: PaddingValues = PaddingValues(SPACING_NORMAL),
    cornerRadius: Int = Dimensions.COMMON_CORNER_RADIUS,
    leftImagePainter: Painter = rememberVectorPainter(image = Icons.Default.Home),
    leftImageTintColor: Color = LIGHT_PINK,
    successIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Done),
    failureIconPainter: Painter = rememberVectorPainter(image = Icons.Outlined.Info),
    successIconTintColor: Color = LIGHT_PINK,
    failureIconTintColor: Color = LIGHT_PINK,
    swipeAbleImagePainter: Painter = painterResource(id = R.drawable.move_forward),
    shouldAutomateSwipeToAnimate: Boolean = false,
    swipeAbleButtonPadding: PaddingValues = PaddingValues(EXTRA_SPACING_SMALL),
    onSwiped: () -> Unit = {},
    onSwipeProgress: ((Float) -> Unit)? = null
) {
    SSJetPackComposeProgressButton(
        assetColor = assetColor,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor
        ),
        buttonBorderWidth = buttonBorderWidth,
        animatedButtonBorderColor = animatedButtonBorderColor,
        buttonBorderColor = buttonBorderColor,
        type = type,
        onClick = onClick,
        buttonState = buttonState,
        width = width,
        height = height,
        padding = padding,
        cornerRadius = cornerRadius,
        leftImagePainter = leftImagePainter,
        leftImageTintColor = leftImageTintColor,
        successIconPainter = successIconPainter,
        failureIconPainter = failureIconPainter,
        successIconTintColor = successIconTintColor,
        failureIconTintColor = failureIconTintColor,
        swipeAbleImagePainter = swipeAbleImagePainter,
        shouldAutomateSwipeToAnimate = shouldAutomateSwipeToAnimate,
        swipeAbleButtonPadding = swipeAbleButtonPadding,
        onSwiped = onSwiped,
        onSwipeAbleButtonDragPercentageUpdate = { percentage ->
            onSwipeProgress?.invoke(percentage)
        }
    )
}

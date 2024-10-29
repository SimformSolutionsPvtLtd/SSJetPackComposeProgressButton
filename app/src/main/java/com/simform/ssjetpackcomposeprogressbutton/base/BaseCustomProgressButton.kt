package com.simform.ssjetpackcomposeprogressbutton.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.simform.ssjetpackcomposeprogressbutton.R
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_NORMAL
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbutton.utils.LIGHT_PINK
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSCustomLoadingEffect
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSJetPackComposeProgressButton

/**
 * A composable function to create a customizable progress button with a focus on supporting
 * custom loading effects, icons, and text styling.
 */
@Composable
fun BaseCustomProgressButton(
    type: SSButtonType = SSButtonType.CUSTOM,
    text: String,
    buttonState: SSButtonState,
    onClick: () -> Unit,
    customLoadingEffect: SSCustomLoadingEffect,
    assetColor: Color = LIGHT_PINK,
    textModifier: Modifier = Modifier.padding(SPACING_SMALL),
    customLoadingIconPainter: Painter = painterResource(id = R.drawable.baby_pink_android)
) {
    SSJetPackComposeProgressButton(
        type = type,
        width = Dimensions.COMMON_WIDTH,
        height = Dimensions.COMMON_HEIGHT,
        onClick = onClick,
        assetColor = assetColor,
        buttonState = buttonState,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            disabledContainerColor = Color.White
        ),
        successIconPainter = painterResource(id = R.drawable.custom_success),
        failureIconPainter = painterResource(id = R.drawable.custom_fail),
        leftImagePainter = painterResource(id = R.drawable.baby_pink_android),
        padding = PaddingValues(SPACING_NORMAL),
        cornerRadius = Dimensions.COMMON_CORNER_RADIUS,
        text = text,
        textModifier = textModifier,
        fontWeight = FontWeight.Bold,
        fontSize = Dimensions.MEDIUM_FONT_SIZE,
        customLoadingEffect = customLoadingEffect,
        customLoadingIconPainter = customLoadingIconPainter,
        buttonBorderWidth = Dimensions.COMMON_BORDER_WIDTH,
        animatedButtonBorderColor = LIGHT_PINK,
        buttonBorderColor = LIGHT_PINK
    )
}

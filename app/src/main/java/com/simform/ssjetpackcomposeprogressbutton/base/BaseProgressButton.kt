package com.simform.ssjetpackcomposeprogressbutton.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_NORMAL
import com.simform.ssjetpackcomposeprogressbutton.utils.LIGHT_PINK
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSJetPackComposeProgressButton

/**
 * A composable function to create a progress button with customizable styles, icons, and animations.
 */
@Composable
fun BaseProgressButton(
    type: SSButtonType,
    buttonState: SSButtonState,
    onClick: () -> Unit,
    assetColor: Color = LIGHT_PINK,
    width: Dp = Dimensions.COMMON_WIDTH,
    height: Dp = Dimensions.COMMON_HEIGHT,
    animatedButtonBorderColor: Color = LIGHT_PINK,
    buttonBorderColor: Color = LIGHT_PINK,
    cornerRadius: Int = Dimensions.COMMON_CORNER_RADIUS,
    buttonBorderWidth: Dp = Dimensions.COMMON_BORDER_WIDTH,
    leftImagePainter: Painter? = null,
    rightImagePainter: Painter? = null,
    successIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Done),
    failureIconPainter: Painter = rememberVectorPainter(image = Icons.Outlined.Info),
    leftImageTintColor: Color = LIGHT_PINK,
    rightImageTintColor: Color = LIGHT_PINK,
    successIconTintColor: Color = LIGHT_PINK,
    failureIconTintColor: Color = LIGHT_PINK,
    padding: PaddingValues = PaddingValues(SPACING_NORMAL),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.White,
        disabledContainerColor = Color.White
    ),
    isBlinkingIcon: Boolean = false,
    blinkingIconColor: Color? = null,
    hourHandColor: Color = Color.Black,
    text: String? = null,
    textModifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontFamily: FontFamily? = null,
    fontWeight: FontWeight? = null
    ) {
    SSJetPackComposeProgressButton(
        assetColor = assetColor,
        colors = colors,
        buttonBorderWidth = buttonBorderWidth,
        animatedButtonBorderColor = animatedButtonBorderColor,
        buttonBorderColor = buttonBorderColor,
        type = type,
        onClick = onClick,
        buttonState = buttonState,
        width = width,
        height = height,
        padding = padding,
        text = text,
        textModifier = textModifier,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        hourHandColor = hourHandColor,
        isBlinkingIcon = isBlinkingIcon,
        blinkingIconColor = blinkingIconColor,
        cornerRadius = cornerRadius,
        leftImagePainter = leftImagePainter,
        leftImageTintColor = leftImageTintColor,
        successIconPainter = successIconPainter,
        failureIconTintColor = failureIconTintColor,
        successIconTintColor = successIconTintColor,
        failureIconPainter = failureIconPainter,
        rightImagePainter = rightImagePainter,
        rightImageTintColor = rightImageTintColor
    )
}

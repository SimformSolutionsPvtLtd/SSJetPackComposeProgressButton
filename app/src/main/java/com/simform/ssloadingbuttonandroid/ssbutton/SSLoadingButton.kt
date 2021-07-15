package com.simform.ssloadingbuttonandroid.ssbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.sizeAnimationMethod
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssAnimateFloatAsState
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssAnimateIntAsState
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedColorAnimation
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedDpAnimation
import com.simform.ssloadingbuttonandroid.ssbutton.PrintLoadingBar.printLoadingBar
import com.simform.ssloadingbuttonandroid.utils.*
import kotlinx.coroutines.delay

object SSLoadingButton {
    @Composable
    fun ssLoadingButton(
        assetColor: Color,
        type: SSButtonType,
        onClick: () -> Unit,
        buttonState: SSButtonState,
        width: Dp,
        height: Dp,
        buttonBorderStroke: BorderStroke? = null,
        blinkingIcon: Boolean = false,
        cornerRadius: Int = twenty,
        speedMillis: Int = thousand,
        enabled: Boolean = true,
        elevation: ButtonElevation? = ButtonDefaults.elevation(),
        colors: ButtonColors = ButtonDefaults.buttonColors(),
        padding: PaddingValues = PaddingValues(0.dp),
        alphaValue: Float = 1f,
        //For Left Icon
        leftImagePainter: Painter? = null,
        rightImagePainter: Painter? = null,
        successIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Done),
        failureIconPainter: Painter = rememberVectorPainter(image = Icons.Outlined.Info),
        //For text if any
        textModifier: Modifier = Modifier,
        text: String? = null,
        fontSize: TextUnit = TextUnit.Unspecified,
        fontStyle: FontStyle? = null,
        fontFamily: FontFamily? = null,
        //For clock animation,Hour hand color
        hourHandColor: Color = Color.Black
    ) {
        var buttonWidth by remember { mutableStateOf(width) }
        var buttonHeight by remember { mutableStateOf(height) }
        var iconAlphaValue by remember { mutableStateOf(oneFloat) }
        var successIconAlphaValue by remember { mutableStateOf(zeroFloat) }
        var failureAlphaValue by remember { mutableStateOf(zeroFloat) }
        var progressAlphaValue by remember { mutableStateOf(zeroFloat) }
        var cornerRadiusValue by remember { mutableStateOf(cornerRadius) }
        val minHeightWidth = if (height > width) {
            width
        } else {
            height
        }
        when (buttonState) {
            SSButtonState.IDLE -> {
                if (height > width) {
                    buttonHeight = height
                } else {
                    buttonWidth = width
                }
                iconAlphaValue = oneFloat
                failureAlphaValue = zeroFloat
                successIconAlphaValue = zeroFloat
                progressAlphaValue = zeroFloat
                cornerRadiusValue = cornerRadius
            }
            SSButtonState.LOADING -> {
                if (height > width) {
                    buttonHeight = width
                } else {
                    buttonWidth = height
                }
                iconAlphaValue = zeroFloat
                failureAlphaValue = zeroFloat
                successIconAlphaValue = zeroFloat
                progressAlphaValue = oneFloat
                cornerRadiusValue = fifty
            }
            SSButtonState.SUCCESS -> {
                LaunchedEffect(key1 = LAUNCH_EFFECT_KEY, block = {
                    if (height > width) {
                        buttonHeight = width
                    } else {
                        buttonWidth = height
                    }
                    iconAlphaValue = zeroFloat
                    failureAlphaValue = zeroFloat
                    successIconAlphaValue = oneFloat
                    progressAlphaValue = zeroFloat
                    cornerRadiusValue = fifty
                    //Delay to show success icon and then IDLE state
                    delay((speedMillis * two).toLong())
                    if (height > width) {
                        buttonHeight = height
                    } else {
                        buttonWidth = width
                    }
                    iconAlphaValue = oneFloat
                    failureAlphaValue = zeroFloat
                    successIconAlphaValue = zeroFloat
                    cornerRadiusValue = cornerRadius
                })
            }
            SSButtonState.FAILIURE -> {
                LaunchedEffect(key1 = LAUNCH_EFFECT_KEY, block = {
                    if (height > width) {
                        buttonHeight = width
                    } else {
                        buttonWidth = height
                    }
                    successIconAlphaValue = zeroFloat
                    iconAlphaValue = zeroFloat
                    progressAlphaValue = zeroFloat
                    failureAlphaValue = oneFloat
                    cornerRadiusValue = fifty
                    //Delay to show failure icon and then IDLE state
                    delay((speedMillis * two).toLong())
                    if (height > width) {
                        buttonHeight = height
                    } else {
                        buttonWidth = width
                    }
                    iconAlphaValue = oneFloat
                    failureAlphaValue = zeroFloat
                    successIconAlphaValue = zeroFloat
                    cornerRadiusValue = cornerRadius
                })
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.graphicsLayer { alpha = alphaValue }) {
            Button(
                onClick = onClick,
                modifier = Modifier
                    .padding(padding)
                    .size(
                        width = sizeAnimationMethod(
                            targetValue = buttonWidth,
                            durationMillis = speedMillis
                        ), height = sizeAnimationMethod(
                            targetValue = buttonHeight,
                            durationMillis = speedMillis
                        )
                    ),
                enabled = enabled,
                elevation = elevation,
                shape = RoundedCornerShape(ssAnimateIntAsState(cornerRadiusValue, speedMillis)),
                border = buttonBorderStroke,
                colors = colors
            ) {}
            //IDLE State icon
            Row(verticalAlignment = Alignment.CenterVertically) {
                leftImagePainter?.let {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(
                                alpha = ssAnimateFloatAsState(
                                    targetValue = iconAlphaValue,
                                    durationMillis = speedMillis
                                )
                            )
                            .size(
                                ssRepeatedDpAnimation(
                                    initialValue = minHeightWidth - twenty.dp,
                                    targetValue = if (blinkingIcon) {
                                        minHeightWidth - ten.dp
                                    } else {
                                        minHeightWidth - twenty.dp
                                    },
                                    durationMillis = speedMillis
                                )
                            ),
                        tint = ssRepeatedColorAnimation(
                            assetColor, if (blinkingIcon) {
                                Color.White
                            } else {
                                assetColor
                            }, speedMillis
                        )
                    )
                }
                val alphaText = ssAnimateFloatAsState(
                    targetValue = iconAlphaValue,
                    durationMillis = speedMillis
                )
                if (text != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.graphicsLayer { alpha = alphaText }) {
                        Text(
                            text = text,
                            modifier = textModifier,
                            color = assetColor,
                            fontSize = fontSize,
                            fontStyle = fontStyle,
                            fontFamily = fontFamily
                        )
                    }
                }
                rightImagePainter?.let {
                    Icon(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(
                                alpha = ssAnimateFloatAsState(
                                    targetValue = iconAlphaValue,
                                    durationMillis = speedMillis
                                )
                            )
                            .size(
                                ssRepeatedDpAnimation(
                                    initialValue = minHeightWidth - twenty.dp,
                                    targetValue = if (blinkingIcon) {
                                        minHeightWidth - ten.dp
                                    } else {
                                        minHeightWidth - twenty.dp
                                    },
                                    durationMillis = speedMillis
                                )
                            ),
                        tint = ssRepeatedColorAnimation(
                            assetColor, if (blinkingIcon) {
                                Color.White
                            } else {
                                assetColor
                            }, speedMillis
                        )
                    )
                }
            }
            //SUCCESS State icon
            Icon(
                painter = successIconPainter,
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(
                        alpha = ssAnimateFloatAsState(
                            targetValue = successIconAlphaValue,
                            durationMillis = speedMillis
                        )
                    )
                    .size(minHeightWidth - twenty.dp),
                tint = assetColor
            )
            //FAILURE State icon
            Icon(
                painter = failureIconPainter,
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(
                        alpha = ssAnimateFloatAsState(
                            targetValue = failureAlphaValue,
                            durationMillis = speedMillis
                        )
                    )
                    .size(minHeightWidth - twenty.dp),
                tint = assetColor
            )
            //LOADING State
            var effectiveMinHeight = minHeightWidth
            buttonBorderStroke?.width?.let {
                effectiveMinHeight = effectiveMinHeight - it - it
            }
            printLoadingBar(
                type = type,
                progressAlpha = ssAnimateFloatAsState(progressAlphaValue, speedMillis),
                assetColor = assetColor,
                minHeightWidth = effectiveMinHeight,
                durationMillis = speedMillis,
                hourHandColor = hourHandColor
            )
        }
    }
}
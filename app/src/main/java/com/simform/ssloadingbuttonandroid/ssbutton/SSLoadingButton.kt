package com.simform.ssloadingbuttonandroid.ssbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.ssbutton.PrintLoadingBar.printLoadingBar
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.sizeAnimationMethod
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssAnimateFloatAsState
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssAnimateIntAsState
import com.simform.ssloadingbuttonandroid.utils.LAUNCH_EFFECT_KEY
import com.simform.ssloadingbuttonandroid.utils.fifty
import com.simform.ssloadingbuttonandroid.utils.oneFloat
import com.simform.ssloadingbuttonandroid.utils.thousand
import com.simform.ssloadingbuttonandroid.utils.twenty
import com.simform.ssloadingbuttonandroid.utils.two
import com.simform.ssloadingbuttonandroid.utils.zeroFloat
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
        cornerRadius: Int = twenty,
        durationMillis: Int = thousand,
        enabled: Boolean = true,
        elevation: ButtonElevation? = ButtonDefaults.elevation(),
        colors: ButtonColors = ButtonDefaults.buttonColors(),
        padding: PaddingValues = PaddingValues(0.dp),
            //For Left Icon
        leftImagePainter: Painter? = null,
        rightImagePainter: Painter? = null,
            //For text if any
        textModifier: Modifier = Modifier,
        text: String? = null,
        fontSize: TextUnit = TextUnit.Unspecified,
        fontStyle: FontStyle? = null,
        fontFamily: FontFamily? = null,
    ) {
        var buttonWidth by remember { mutableStateOf(width) }
        var buttonHeight by remember { mutableStateOf(height) }
        var iconAlphaValue by remember { mutableStateOf(oneFloat) }
        var successIconAlphaValue by remember { mutableStateOf(zeroFloat) }
        var failureAlphaValue by remember { mutableStateOf(zeroFloat) }
        var progressAlphaValue by remember { mutableStateOf(zeroFloat) }
        var cornerRadiusValue by remember { mutableStateOf( cornerRadius) }
        val minHeightWidth = if (height > width) { width} else { height}

        when (buttonState) {
            SSButtonState.IDLE -> {
                if (height > width) { buttonHeight = height} else { buttonWidth = width}
                iconAlphaValue = oneFloat
                failureAlphaValue = zeroFloat
                successIconAlphaValue = zeroFloat
                progressAlphaValue = zeroFloat
                cornerRadiusValue = cornerRadius
            }
            SSButtonState.LOADING -> {
                if (height > width) { buttonHeight = width} else { buttonWidth = height}
                iconAlphaValue = zeroFloat
                failureAlphaValue = zeroFloat
                successIconAlphaValue = zeroFloat
                progressAlphaValue = oneFloat
                cornerRadiusValue = fifty
            }
            SSButtonState.SUCCESS -> {
                if (height > width) { buttonHeight = width} else { buttonWidth = height}
                iconAlphaValue = zeroFloat
                failureAlphaValue = zeroFloat
                successIconAlphaValue = oneFloat
                progressAlphaValue = zeroFloat
                cornerRadiusValue = fifty
            }
            SSButtonState.FAILIURE -> {
                LaunchedEffect(key1 = LAUNCH_EFFECT_KEY, block = {
                    if (height > width) { buttonHeight = width} else { buttonWidth = height}
                    successIconAlphaValue = zeroFloat
                    iconAlphaValue = zeroFloat
                    progressAlphaValue = zeroFloat
                    failureAlphaValue = oneFloat
                    cornerRadiusValue = fifty
                    //Delay to show failure icon and then IDLE state
                    delay((durationMillis * two).toLong())
                    if (height > width) { buttonHeight = height} else { buttonWidth = width}
                    iconAlphaValue = oneFloat
                    failureAlphaValue = zeroFloat
                    cornerRadiusValue = cornerRadius
                } )

            }
        }
        Box(contentAlignment = Alignment.Center) {
            Button(
                onClick = onClick,
                modifier = Modifier
                        .padding(padding)
                        .size(
                                width = sizeAnimationMethod(
                                        targetValue = buttonWidth,
                                        durationMillis = durationMillis
                                ), height = sizeAnimationMethod(
                                targetValue = buttonHeight,
                                durationMillis = durationMillis
                        )
                        ),
                enabled = enabled,
                elevation = elevation,
                shape = RoundedCornerShape(ssAnimateIntAsState(cornerRadiusValue,durationMillis)),
                border = buttonBorderStroke,
                colors = colors
            ) {}
            //IDLE State icon
            Row( verticalAlignment = Alignment.CenterVertically) {
                leftImagePainter?.let {
                    Icon(
                            painter = it,
                            contentDescription = null,
                            modifier = Modifier
                                    .graphicsLayer(
                                            alpha = ssAnimateFloatAsState(
                                                    targetValue = iconAlphaValue,
                                                    durationMillis = durationMillis
                                            )
                                    )
                                    .size(minHeightWidth - twenty.dp),
                            tint = assetColor
                    )
                }
                val alphaTemp = ssAnimateFloatAsState(
                targetValue = iconAlphaValue,
                durationMillis = durationMillis
                )
                if (text != null) {
                    Row( verticalAlignment = Alignment.CenterVertically, modifier = Modifier.graphicsLayer { alpha = alphaTemp }) {
                        Text(text = text, modifier = textModifier, color = assetColor, fontSize = fontSize, fontStyle = fontStyle, fontFamily = fontFamily)
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
                                                    durationMillis = durationMillis
                                            )
                                    )
                                    .size(minHeightWidth - twenty.dp),
                            tint = assetColor
                    )
                }
            }
            //SUCCESS State icon
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = null,
                modifier = Modifier
                        .graphicsLayer(
                                alpha = ssAnimateFloatAsState(
                                        targetValue = successIconAlphaValue,
                                        durationMillis = durationMillis
                                )
                        )
                        .size(minHeightWidth - twenty.dp),
                tint = assetColor
            )
            //FAILURE State icon
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                modifier = Modifier
                        .graphicsLayer(
                                alpha = ssAnimateFloatAsState(
                                        targetValue = failureAlphaValue,
                                        durationMillis = durationMillis
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
            printLoadingBar(type = type, progressAlpha = ssAnimateFloatAsState(progressAlphaValue,durationMillis), assetColor = assetColor, minHeightWidth = effectiveMinHeight, durationMillis = durationMillis)
        }
    }
}
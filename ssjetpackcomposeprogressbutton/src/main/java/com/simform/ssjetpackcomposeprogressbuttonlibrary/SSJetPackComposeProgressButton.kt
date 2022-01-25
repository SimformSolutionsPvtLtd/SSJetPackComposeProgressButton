package com.simform.ssjetpackcomposeprogressbuttonlibrary

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Info
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.LAUNCH_EFFECT_KEY
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ZERO
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.fifty
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.oneFloat
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ten
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.thousand
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.twenty
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.two
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.zeroFloat
import kotlinx.coroutines.delay

/**
 * @param type of animation from SSButtonType in loading state.
 * @param width Width to be applied to the button.
 * @param height Height to be applied to the button.
 * @param onClick Will be called when the user clicks the button.
 * @param assetColor Color to be applied to icon and text inside button.
 * @param buttonState represent the state of button from IDLE, LOADING, SUCCESS, FAILIURE from SSButtonState.
 * @param buttonBorderStroke Border to draw around the button.
 * @param blinkingIcon Icon will be blink with size and color.
 * @param cornerRadius Corner radius to be applied to the button.
 * @param speedMillis Speed of the animation while changing the state.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable.
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different.
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * elevation for this button. See [ButtonDefaults.elevation].
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param padding The spacing values to apply internally between the container and the content.
 * @param alphaValue The alpha of the drawn area. Setting this to something other than `1`
 * will cause the drawn contents to be translucent and setting it to `0` will
 * cause it to be fully invisible. Default value is `1` and the range is between
 * `0` and `1`.
 * @leftImagePainter painter [Painter] to draw inside this left Icon.
 * @rightImagePainter painter [Painter] to draw inside this right Icon.
 * @successIconPainter painter [Painter] to draw inside this success state Icon.
 * @failureIconPainter painter [Painter] to draw inside this failiure state Icon.
 * @successIconColor Color to be applied to success icon.
 * @failureIconColor Color to be applied to failure icon.
 * @param text The text to be displayed.
 * @param textModifier [Modifier] to apply to this text layout node.
 * @param fontSize The size of glyphs to use when painting the text. See [TextStyle.fontSize].
 * @param fontStyle The typeface variant to use when drawing the letters (e.g., italic).
 * @param fontFamily The font family to be used when rendering the text. See [TextStyle.fontFamily].
 * @param fontWeight The typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).
 * @param hourHandColor Color will be apply to hour hand in clock type animation only.
 * @param customLoadingIconPainter painter [Painter] to draw your custom loading icon.
 * @param customLoadingEffect custom loading animation type.
 * @param customLoadingPadding spacing between button border and loading icon.
 * @param shouldAutoMoveToIdleState In case of success/failure state after defined time it move back to idle state
 */

@Composable
fun SSJetPackComposeProgressButton(
    type: SSButtonType,
    width: Dp,
    height: Dp,
    onClick: () -> Unit,
    assetColor: Color,
    buttonState: SSButtonState,
    buttonBorderStroke: BorderStroke? = null,
    blinkingIcon: Boolean = false,
    cornerRadius: Int = twenty,
    speedMillis: Int = thousand,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    padding: PaddingValues = PaddingValues(0.dp),
    alphaValue: Float = 1f,
    leftImagePainter: Painter? = null,
    rightImagePainter: Painter? = null,
    successIconPainter: Painter = rememberVectorPainter(image = Icons.Default.Done),
    failureIconPainter: Painter = rememberVectorPainter(image = Icons.Outlined.Info),
    successIconColor: Color = assetColor,
    failureIconColor: Color = assetColor,
    text: String? = null,
    textModifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontFamily: FontFamily? = null,
    fontWeight: FontWeight? = null,
    hourHandColor: Color = Color.Black,
    customLoadingIconPainter: Painter = painterResource(id = R.drawable.simform_logo),
    customLoadingEffect: SSCustomLoadingEffect = SSCustomLoadingEffect(
        rotation = false,
        zoomInOut = false,
        colorChanger = false
    ),
    customLoadingPadding: Int = ZERO,
    shouldAutoMoveToIdleState: Boolean = true
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

                if (shouldAutoMoveToIdleState) {
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
                }
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

                if (shouldAutoMoveToIdleState) {
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
                }
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
            enabled = enabled && buttonState != SSButtonState.LOADING,
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
                        fontFamily = fontFamily,
                        fontWeight = fontWeight
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
            tint = successIconColor
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
            tint = failureIconColor
        )
        //LOADING State
        var effectiveMinHeight = minHeightWidth
        buttonBorderStroke?.width?.let {
            effectiveMinHeight = effectiveMinHeight - it - it
        }
        PrintLoadingBar(
            type = type,
            progressAlpha = ssAnimateFloatAsState(progressAlphaValue, speedMillis),
            assetColor = assetColor,
            minHeightWidth = effectiveMinHeight,
            durationMillis = speedMillis,
            hourHandColor = hourHandColor,
            customLoadingIconPainter = customLoadingIconPainter,
            customLoadingEffect = customLoadingEffect,
            customLoadingPadding = customLoadingPadding
        )
    }
}
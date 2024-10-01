package com.simform.ssjetpackcomposeprogressbuttonlibrary

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.DEFAULT_ANIMATION_SPEED
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.DISABLE_VIEW_ALPHA
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.COMMON_CORNER_RADIUS
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.SPACING_LARGE
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.Dimens.SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ENABLE_VIEW_ALPHA
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.LAUNCH_EFFECT_KEY
import kotlinx.coroutines.delay

/**
 * @param type of animation from SSButtonType in loading state.
 * @param width Width to be applied to the button.
 * @param height Height to be applied to the button.
 * @param onClick Will be called when the user clicks the button.
 * @param assetColor Color to be applied to icon and text inside button.
 * @param buttonState represent the state of button from IDLE, LOADING, SUCCESS, FAILURE from SSButtonState.
 * @param buttonState represent the state of button from IDLE, LOADING, SUCCESS, FAILIURE from SSButtonState.
 * @param buttonBorderWidth Border width to draw around the button.
 * @param buttonBorderColor Border color applied to button.
 * @param animatedButtonBorderColor Border color applied to button while in LOADING state.
 * @param isBlinkingIcon Icon will be blink with size and color.
 * @param blinkingIconColor Color which will be used with tintcolor for animation when `isBlinkingIcon`
 * enabled
 * @param cornerRadius Corner radius to be applied to the button.
 * @param speedMillis Speed of the animation while changing the state.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable.
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different.
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * elevation for this button. See [ButtonDefaults.elevatedButtonElevation].
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param padding The spacing values to apply internally between the container and the content.
 * @param alphaValue The alpha of the drawn area. Setting this to something other than `1`
 * will cause the drawn contents to be translucent and setting it to `0` will
 * cause it to be fully invisible. Default value is `1` and the range is between
 * `0` and `1`.
 * @param leftImagePainter painter [Painter] to draw inside this left Icon.
 * @param leftImageTintColor tint color for left Icon.
 * @param rightImagePainter painter [Painter] to draw inside this right Icon.
 * @param rightImageTintColor tint color for right Icon.
 * @param successIconPainter painter [Painter] to draw inside this success state Icon.
 * @param successIconTintColor tint color for success Icon.
 * @param failureIconPainter painter [Painter] to draw inside this failure state Icon.
 * @param failureIconTintColor tint color for failure Icon.
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
    buttonBorderWidth: Dp? = 0.dp,
    buttonBorderColor: Color? = null,
    animatedButtonBorderColor: Color? = null,
    isBlinkingIcon: Boolean = false,
    blinkingIconColor: Color? = null,
    cornerRadius: Int = 0,
    speedMillis: Int = DEFAULT_ANIMATION_SPEED,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    padding: PaddingValues = PaddingValues(0.dp),
    alphaValue: Float = 1f,
    leftImagePainter: Painter? = null,
    leftImageTintColor: Color? = null,
    rightImagePainter: Painter? = null,
    rightImageTintColor: Color? = null,
    successIconPainter: Painter? = null,
    successIconTintColor: Color? = null,
    failureIconPainter: Painter? = null,
    failureIconTintColor: Color? = null,
    text: String? = null,
    textModifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontFamily: FontFamily? = null,
    fontWeight: FontWeight? = null,
    hourHandColor: Color = Color.Black,
    customLoadingIconPainter: Painter? = null,
    customLoadingEffect: SSCustomLoadingEffect = SSCustomLoadingEffect(
        rotation = false,
        zoomInOut = false,
        fadeInOut = false
    ),
    shouldAutoMoveToIdleState: Boolean = true,
    customLoadingPadding: Int = 0
) {
    var buttonWidth by remember { mutableStateOf(width) }
    var buttonHeight by remember { mutableStateOf(height) }
    var iconAlphaValue by remember { mutableFloatStateOf(ENABLE_VIEW_ALPHA) }
    var successIconAlphaValue by remember { mutableFloatStateOf(DISABLE_VIEW_ALPHA) }
    var failureAlphaValue by remember { mutableFloatStateOf(DISABLE_VIEW_ALPHA) }
    var progressAlphaValue by remember { mutableFloatStateOf(DISABLE_VIEW_ALPHA) }
    var cornerRadiusValue by remember { mutableIntStateOf(cornerRadius) }
    val borderColor by animateColorAsState(
        targetValue = (
                if (buttonState == SSButtonState.LOADING)
                    animatedButtonBorderColor
                else
                    buttonBorderColor
                ) ?: Color.Transparent,
        animationSpec = tween(
            durationMillis = speedMillis,
            easing = LinearOutSlowInEasing
        ),
        label = "",
    )
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
            iconAlphaValue = ENABLE_VIEW_ALPHA
            failureAlphaValue = DISABLE_VIEW_ALPHA
            successIconAlphaValue = DISABLE_VIEW_ALPHA
            progressAlphaValue = DISABLE_VIEW_ALPHA
            cornerRadiusValue = cornerRadius
        }
        SSButtonState.LOADING -> {
            if (height > width) {
                buttonHeight = width
            } else {
                buttonWidth = height
            }
            iconAlphaValue = DISABLE_VIEW_ALPHA
            failureAlphaValue = DISABLE_VIEW_ALPHA
            successIconAlphaValue = DISABLE_VIEW_ALPHA
            progressAlphaValue = ENABLE_VIEW_ALPHA
            cornerRadiusValue = COMMON_CORNER_RADIUS
        }
        SSButtonState.SUCCESS -> {
            LaunchedEffect(key1 = LAUNCH_EFFECT_KEY, block = {
                if (height > width) {
                    buttonHeight = width
                } else {
                    buttonWidth = height
                }
                iconAlphaValue = DISABLE_VIEW_ALPHA
                failureAlphaValue = DISABLE_VIEW_ALPHA
                successIconAlphaValue = ENABLE_VIEW_ALPHA
                progressAlphaValue = DISABLE_VIEW_ALPHA
                cornerRadiusValue = COMMON_CORNER_RADIUS
                if (shouldAutoMoveToIdleState) {
                    //Delay to show success icon and then IDLE state
                    successIconPainter?.let {
                        delay((speedMillis * 2).toLong())
                    }
                    if (height > width) {
                        buttonHeight = height
                    } else {
                        buttonWidth = width
                    }
                    iconAlphaValue = ENABLE_VIEW_ALPHA
                    failureAlphaValue = DISABLE_VIEW_ALPHA
                    successIconAlphaValue = DISABLE_VIEW_ALPHA
                    cornerRadiusValue = cornerRadius
                }
            })
        }
        SSButtonState.FAILURE -> {
            LaunchedEffect(key1 = LAUNCH_EFFECT_KEY, block = {
                if (height > width) {
                    buttonHeight = width
                } else {
                    buttonWidth = height
                }
                successIconAlphaValue = DISABLE_VIEW_ALPHA
                iconAlphaValue = DISABLE_VIEW_ALPHA
                progressAlphaValue = DISABLE_VIEW_ALPHA
                failureAlphaValue = ENABLE_VIEW_ALPHA
                cornerRadiusValue = COMMON_CORNER_RADIUS

                if (shouldAutoMoveToIdleState) {
                    //Delay to show failure icon and then IDLE state
                    failureIconPainter?.let {
                        delay((speedMillis * 2).toLong())
                    }
                    if (height > width) {
                        buttonHeight = height
                    } else {
                        buttonWidth = width
                    }
                    iconAlphaValue = ENABLE_VIEW_ALPHA
                    failureAlphaValue = DISABLE_VIEW_ALPHA
                    successIconAlphaValue = DISABLE_VIEW_ALPHA
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
            border = BorderStroke(
                width = buttonBorderWidth ?: 0.dp,
                color = borderColor
            ),
            colors = colors
        ) {}
        //IDLE State icon
        Row(verticalAlignment = Alignment.CenterVertically) {
            leftImagePainter?.let {
                Image(
                    painter = it,
                    contentDescription = null,
                    colorFilter = getTintColor(
                        isBlinkingIcon = isBlinkingIcon,
                        blinkingIconColor = blinkingIconColor,
                        tintColor = leftImageTintColor,
                        duration = speedMillis
                    ),
                    modifier = Modifier
                        .graphicsLayer(
                            alpha = ssAnimateFloatAsState(
                                targetValue = iconAlphaValue,
                                durationMillis = speedMillis
                            )
                        )
                        .size(
                            ssRepeatedDpAnimation(
                                initialValue = minHeightWidth - SPACING_LARGE,
                                targetValue = if (isBlinkingIcon) {
                                    minHeightWidth - SPACING_SMALL
                                } else {
                                    minHeightWidth - SPACING_LARGE
                                },
                                durationMillis = speedMillis
                            )
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
                Image(
                    painter = it,
                    contentDescription = null,
                    colorFilter = getTintColor(
                        isBlinkingIcon = isBlinkingIcon,
                        blinkingIconColor = blinkingIconColor,
                        tintColor = rightImageTintColor,
                        duration = speedMillis
                    ),
                    modifier = Modifier
                        .graphicsLayer(
                            alpha = ssAnimateFloatAsState(
                                targetValue = iconAlphaValue,
                                durationMillis = speedMillis
                            )
                        )
                        .size(
                            ssRepeatedDpAnimation(
                                initialValue = minHeightWidth - SPACING_LARGE,
                                targetValue = if (isBlinkingIcon) {
                                    minHeightWidth - SPACING_SMALL
                                } else {
                                    minHeightWidth - SPACING_LARGE
                                },
                                durationMillis = speedMillis
                            )
                        )
                )
            }
        }
        //SUCCESS State icon
        successIconPainter?.let {
            Image(
                painter = successIconPainter,
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(
                        alpha = ssAnimateFloatAsState(
                            targetValue = successIconAlphaValue,
                            durationMillis = speedMillis
                        )
                    )
                    .size(minHeightWidth - SPACING_LARGE),
                colorFilter = successIconTintColor?.let { ColorFilter.tint(it) }
            )
        }
        //FAILURE State icon
        failureIconPainter?.let {
            Image(
                painter = failureIconPainter,
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(
                        alpha = ssAnimateFloatAsState(
                            targetValue = failureAlphaValue,
                            durationMillis = speedMillis
                        )
                    )
                    .size(minHeightWidth - SPACING_LARGE),
                colorFilter = failureIconTintColor?.let { ColorFilter.tint(it) }
            )
        }
        //LOADING State
        var effectiveMinHeight = minHeightWidth
        buttonBorderWidth?.let {
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

@Composable
private fun getTintColor(
    isBlinkingIcon: Boolean,
    blinkingIconColor: Color? = null,
    tintColor: Color? = null,
    duration: Int = 0
): ColorFilter? {
    return tintColor?.let {
        if (isBlinkingIcon) {
            ColorFilter.tint(
                ssRepeatedColorAnimation(
                    it,
                    blinkingIconColor ?: Color.Transparent,
                    duration
                )
            )
        } else {
            ColorFilter.tint(it)
        }
    }
}

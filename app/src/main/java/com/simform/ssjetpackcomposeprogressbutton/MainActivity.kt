package com.simform.ssjetpackcomposeprogressbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.simform.ssjetpackcomposeprogressbutton.base.BaseCustomProgressButton
import com.simform.ssjetpackcomposeprogressbutton.base.BaseProgressButton
import com.simform.ssjetpackcomposeprogressbutton.base.BaseSwipeAbleProgressButton
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_LARGE
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_MEDIUM
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_NORMAL
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SPACING_SMALL
import com.simform.ssjetpackcomposeprogressbutton.utils.Dimensions.SWIPE_BUTTON_CORNER_RADIUS
import com.simform.ssjetpackcomposeprogressbutton.utils.LIGHT_BLUE
import com.simform.ssjetpackcomposeprogressbutton.utils.LIGHT_PINK
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSCustomLoadingEffect
import com.simform.ssjetpackcomposeprogressbuttonlibrary.gifPainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSLoadingButtonExample()
        }
    }

    companion object {
        const val LOADING_GIF_URL = "https://icons8.com/preloaders/preloaders/810/Rainbow-128.gif"
    }
}

@Composable
fun SSLoadingButtonExample() {
    var roundedProgressState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var wheelState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var zoomInOutState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var clockState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var roundedProgressState2: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var spiralState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var ssTextButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithRightButton: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithIconState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var blinkingIcon: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var automaticSwipeToAnimateButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var swipeToAnimateButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customRotationButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customZoomButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customEffectButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customGifButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }

    Column {
        Spacer(modifier = Modifier.size(SPACING_MEDIUM))
        Row(
            Modifier
                .padding(0.dp, 0.dp, 0.dp, SPACING_LARGE)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    roundedProgressState = SSButtonState.SUCCESS
                    wheelState = SSButtonState.SUCCESS
                    zoomInOutState = SSButtonState.SUCCESS
                    clockState = SSButtonState.SUCCESS
                    roundedProgressState2 = SSButtonState.SUCCESS
                    spiralState = SSButtonState.SUCCESS
                    ssTextButtonState = SSButtonState.SUCCESS
                    textWithIconState = SSButtonState.SUCCESS
                    textWithRightButton = SSButtonState.SUCCESS
                    blinkingIcon = SSButtonState.SUCCESS
                    customRotationButtonState = SSButtonState.SUCCESS
                    customZoomButtonState = SSButtonState.SUCCESS
                    customEffectButtonState = SSButtonState.SUCCESS
                    customGifButtonState = SSButtonState.SUCCESS
                    automaticSwipeToAnimateButtonState = SSButtonState.SUCCESS
                    swipeToAnimateButtonState = SSButtonState.SUCCESS
                },
                modifier = Modifier
                    .padding(SPACING_NORMAL)
                    .weight(1f)
                    .height(Dimensions.TOP_BUTTON_HEIGHT),
                shape = RoundedCornerShape(Dimensions.TOP_BUTTON_RADIUS),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                colors = ButtonDefaults.buttonColors(containerColor = LIGHT_BLUE)
            ) {
                Text(
                    text = stringResource(id = R.string.on_success),
                    color = Color.White,
                    fontSize = Dimensions.MEDIUM_FONT_SIZE
                )
            }
            Button(
                onClick = {
                    roundedProgressState = SSButtonState.FAILURE
                    wheelState = SSButtonState.FAILURE
                    zoomInOutState = SSButtonState.FAILURE
                    clockState = SSButtonState.FAILURE
                    roundedProgressState2 = SSButtonState.FAILURE
                    spiralState = SSButtonState.FAILURE
                    ssTextButtonState = SSButtonState.FAILURE
                    textWithIconState = SSButtonState.FAILURE
                    textWithRightButton = SSButtonState.FAILURE
                    blinkingIcon = SSButtonState.FAILURE
                    customRotationButtonState = SSButtonState.FAILURE
                    customEffectButtonState = SSButtonState.FAILURE
                    customZoomButtonState = SSButtonState.FAILURE
                    customGifButtonState = SSButtonState.FAILURE
                    automaticSwipeToAnimateButtonState = SSButtonState.FAILURE
                    swipeToAnimateButtonState = SSButtonState.FAILURE
                },
                modifier = Modifier
                    .padding(SPACING_NORMAL)
                    .weight(1f)
                    .height(Dimensions.TOP_BUTTON_HEIGHT),
                shape = RoundedCornerShape(Dimensions.TOP_BUTTON_RADIUS),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                colors = ButtonDefaults.buttonColors(containerColor = LIGHT_BLUE)
            ) {
                Text(
                    text = stringResource(id = R.string.on_failure),
                    color = Color.White,
                    fontSize = Dimensions.MEDIUM_FONT_SIZE
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .scrollable(
                    state = ScrollableState { 0f },
                    orientation = Orientation.Vertical,
                    enabled = true
                )
                .padding(0.dp, 0.dp, SPACING_SMALL, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Various example of SSLoadingButton
            item {
                BaseProgressButton(
                    type = SSButtonType.CIRCLE,
                    onClick = { roundedProgressState2 = SSButtonState.LOADING },
                    buttonState = roundedProgressState2,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                BaseProgressButton(
                    type = SSButtonType.WHEEL,
                    onClick = { wheelState = SSButtonState.LOADING },
                    buttonState = wheelState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                BaseProgressButton(
                    type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                    onClick = { zoomInOutState = SSButtonState.LOADING },
                    buttonState = zoomInOutState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                BaseProgressButton(
                    type = SSButtonType.CLOCK,
                    onClick = { clockState = SSButtonState.LOADING },
                    buttonState = clockState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                BaseProgressButton(
                    type = SSButtonType.SPIRAL,
                    onClick = { spiralState = SSButtonState.LOADING },
                    buttonState = spiralState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                BaseProgressButton(
                    assetColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LIGHT_PINK,
                        disabledContainerColor = LIGHT_PINK
                    ),
                    type = SSButtonType.CIRCLE,
                    onClick = { roundedProgressState = SSButtonState.LOADING },
                    buttonState = roundedProgressState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Person),
                    leftImageTintColor = Color.White,
                    failureIconTintColor = Color.White,
                    successIconTintColor = Color.White
                )
                BaseProgressButton(
                    assetColor = Color.Yellow,
                    type = SSButtonType.CLOCK,
                    onClick = { blinkingIcon = SSButtonState.LOADING },
                    buttonState = blinkingIcon,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.FavoriteBorder),
                    isBlinkingIcon = true,
                    blinkingIconColor = Color.Yellow,
                    leftImageTintColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LIGHT_PINK,
                        disabledContainerColor = LIGHT_PINK
                    ),
                    failureIconTintColor = Color.White,
                    successIconTintColor = Color.White,
                    hourHandColor = Color.White,
                )
                BaseProgressButton(
                    assetColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LIGHT_PINK,
                        disabledContainerColor = LIGHT_PINK
                    ),
                    type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                    onClick = { ssTextButtonState = SSButtonState.LOADING },
                    buttonState = ssTextButtonState,
                    text = stringResource(id = R.string.stylish_text),
                    fontStyle = FontStyle.Italic,
                    fontSize = Dimensions.MEDIUM_FONT_SIZE,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    textModifier = Modifier.padding(12.dp),
                    failureIconTintColor = Color.White,
                    successIconTintColor = Color.White
                )
                BaseProgressButton(
                    assetColor = Color.White,
                    type = SSButtonType.WHEEL,
                    onClick = { textWithIconState = SSButtonState.LOADING },
                    buttonState = textWithIconState,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                    leftImageTintColor = Color.White,
                    blinkingIconColor = Color.White,
                    text = stringResource(id = R.string.left_icon),
                    fontFamily = FontFamily.SansSerif,
                    textModifier = Modifier.padding(SPACING_NORMAL),
                    fontSize = Dimensions.MEDIUM_FONT_SIZE,
                    fontWeight = FontWeight.Bold,
                    isBlinkingIcon = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LIGHT_PINK,
                        disabledContainerColor = LIGHT_PINK
                    ),
                    failureIconTintColor = Color.White,
                    successIconTintColor = Color.White
                )
                BaseProgressButton(
                    assetColor = Color.White,
                    type = SSButtonType.SPIRAL,
                    onClick = { textWithRightButton = SSButtonState.LOADING },
                    buttonState = textWithRightButton,
                    width = Dimensions.COMMON_WIDTH,
                    height = Dimensions.COMMON_HEIGHT,
                    rightImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                    rightImageTintColor = Color.White,
                    text = stringResource(id = R.string.right_icon),
                    fontFamily = FontFamily.Serif,
                    textModifier = Modifier.padding(SPACING_NORMAL),
                    fontSize = Dimensions.MEDIUM_FONT_SIZE,
                    fontWeight = FontWeight.Bold,
                    failureIconTintColor = Color.White,
                    successIconTintColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LIGHT_PINK,
                        disabledContainerColor = LIGHT_PINK
                    )
                )
                BaseSwipeAbleProgressButton(
                    type = SSButtonType.CIRCLE,
                    onClick = { automaticSwipeToAnimateButtonState = SSButtonState.LOADING },
                    buttonState = automaticSwipeToAnimateButtonState,
                    shouldAutomateSwipeToAnimate = true,
                    onSwiped = {
                        automaticSwipeToAnimateButtonState = SSButtonState.LOADING
                    }
                )
                BaseSwipeAbleProgressButton(
                    type = SSButtonType.CIRCLE,
                    onClick = { swipeToAnimateButtonState = SSButtonState.LOADING },
                    buttonState = swipeToAnimateButtonState,
                    cornerRadius = SWIPE_BUTTON_CORNER_RADIUS,
                    onSwipeProgress = { percentage ->
                        // Get the swipe progress over here
                        Log.d("Swipe progress update >", "$percentage")
                    },
                    onSwiped = {
                        swipeToAnimateButtonState = SSButtonState.LOADING
                    }
                )
                Spacer(modifier = Modifier.size(Dimensions.COMMON_HEIGHT))
                BaseCustomProgressButton(
                    text = stringResource(id = R.string.lbl_rotation_animation),
                    buttonState = customRotationButtonState,
                    onClick = { customRotationButtonState = SSButtonState.LOADING },
                    customLoadingEffect = SSCustomLoadingEffect(rotation = true),
                )
                BaseCustomProgressButton(
                    text = stringResource(id = R.string.lbl_zoom_in_out_animation),
                    buttonState = customZoomButtonState,
                    onClick = { customZoomButtonState = SSButtonState.LOADING },
                    customLoadingEffect = SSCustomLoadingEffect(zoomInOut = true),
                )
                BaseCustomProgressButton(
                    text = stringResource(id = R.string.lbl_fade_in_out_animation),
                    buttonState = customEffectButtonState,
                    onClick = { customEffectButtonState = SSButtonState.LOADING },
                    customLoadingEffect = SSCustomLoadingEffect(fadeInOut = true),
                )
                BaseCustomProgressButton(
                    text = stringResource(id = R.string.gif_loader),
                    buttonState = customGifButtonState,
                    onClick = { customGifButtonState = SSButtonState.LOADING },
                    customLoadingEffect = SSCustomLoadingEffect(gif = true),
                    customLoadingIconPainter = gifPainter(
                        data = MainActivity.LOADING_GIF_URL,
                        drawable = ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.baby_pink_android
                        )
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSLoadingButtonExample()
}
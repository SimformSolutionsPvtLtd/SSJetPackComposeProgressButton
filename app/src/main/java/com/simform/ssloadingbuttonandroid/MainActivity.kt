package com.simform.ssloadingbuttonandroid

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.ui.theme.SSLoadingButtonAndroidTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.simform.ssloadingbuttonandroid.ui.theme.AnimationUtils.progressRotationMethod
import com.simform.ssloadingbuttonandroid.ui.theme.AnimationUtils.sizeAnimationMethod
import com.simform.ssloadingbuttonandroid.ui.theme.AnimationUtils.progressDpMethod
import com.simform.ssloadingbuttonandroid.utils.oneFloat
import com.simform.ssloadingbuttonandroid.utils.threeSixtyFloat
import com.simform.ssloadingbuttonandroid.utils.zeroFloat
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSLoadingButtonAndroidTheme {
                Surface(color = MaterialTheme.colors.background) {
                    context = LocalContext.current
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Greeting() {
    var roundedProgressState: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }
    var wheelState: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }
    var zoomInOutState: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }
    var clockState: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }
    var roundedProgressState2: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }
    var spiralState: ButtonStateList by remember { mutableStateOf(ButtonStateList.IDLE) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .scrollable(
                state = ScrollableState { 0f },
                orientation = Orientation.Vertical,
                enabled = true
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row() {
            Button(
                onClick = {
                          roundedProgressState = ButtonStateList.SUCCESS
                    wheelState = ButtonStateList.SUCCESS
                    zoomInOutState = ButtonStateList.SUCCESS
                    clockState = ButtonStateList.SUCCESS
                    roundedProgressState2 = ButtonStateList.SUCCESS
                    spiralState = ButtonStateList.SUCCESS

                          },
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.elevation()
            ) {
                Text(text = "On Success")
            }
            Button(
                onClick = {
                    roundedProgressState = ButtonStateList.FAILIURE
                    wheelState = ButtonStateList.FAILIURE
                    zoomInOutState = ButtonStateList.FAILIURE
                    clockState = ButtonStateList.FAILIURE
                    roundedProgressState2 = ButtonStateList.FAILIURE
                    spiralState = ButtonStateList.FAILIURE
                          },
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.elevation()
            ) {
                Text(text = "On Failure")
            }
            }
        }
        item {
            //************************************** Button 2 ******************************************//
            var widthSize by remember { mutableStateOf(375.dp) }
            var state by remember { mutableStateOf(true) }
            val width by animateDpAsState(
                targetValue = widthSize,
                tween(
                    durationMillis = 3000,
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing
                ),
                finishedListener = {
                    if (widthSize == 100.dp) {
                        widthSize = 375.dp
                        state = !state
                    }
                }
            )
            Button(
                onClick = {
                    widthSize = if (state) {
                        100.dp
                    } else {
                        375.dp
                    }
                    state = !state
                },
                modifier = Modifier
                    .padding(10.dp)
                    .sizeIn(minWidth = width),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Red
                ),
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Red))
            ) {
                Text(text = "Button 2")
            }


            //************************************** Button 3 ******************************************//
            val infiniteTransition = rememberInfiniteTransition()
            val scaleAnim by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1.5f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000),
                    repeatMode = RepeatMode.Restart
                )
            )
            val colorAnim by infiniteTransition.animateColor(
                initialValue = Color.White,
                targetValue = Color.Red,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(50)
            ) {
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer(scaleX = scaleAnim, scaleY = scaleAnim)
                        .padding(end = 8.dp),
                    tint = colorAnim
                )
            }
            //********************************************************************************//
            var useRed by remember { mutableStateOf(false) }
            var toState by remember { mutableStateOf(ComponentState.Released) }
            val transition: Transition<ComponentState> =
                updateTransition(targetState = toState, null)
            val scale: Float by transition.animateFloat(
                transitionSpec = { spring(stiffness = 50f) }
            ) { state ->
                if (state == ComponentState.Pressed) 2f else 1f
            }
            val color: Color by transition.animateColor(transitionSpec = {
                when {
                    ComponentState.Pressed isTransitioningTo ComponentState.Released ->
                        spring(stiffness = 50f)
                    else ->
                        tween(durationMillis = 500)
                }
            }) { state ->
                when (state) {
                    ComponentState.Pressed -> Color.Gray
                    ComponentState.Released -> Color.Blue
                }
            }
            Button(
                onClick = {
                    useRed = !useRed
                    if (useRed) {
                        toState = ComponentState.Pressed
                    } else {
                        toState = ComponentState.Released
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .size((100 * scale).dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = color,
                    contentColor = Color.White
                ),
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.DarkGray)),
                shape = RoundedCornerShape(50)

            ) {
                Text(text = "Hello")
            }


            //**********************************SSLoadingButton Start from here ******************************************//


            SSLoadingButton(
                assetColor = Color.White,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(Color.Red)),
                type = ButtonType.ROUNDED_PROGRESS,
                onClick = {
                    roundedProgressState = ButtonStateList.LOADING
                },
                currentState = roundedProgressState,
                width = 370.dp, height = 50.dp, padding = PaddingValues(10.dp),
                durationMillis = 500

            )
            SSLoadingButton(
                assetColor = colorResource(id = R.color.dark_green),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(colorResource(id = R.color.dark_green))),
                type = ButtonType.WHEEL,
                onClick = {
                    wheelState = ButtonStateList.LOADING
                },
                currentState = wheelState,
                width = 370.dp, height = 50.dp, padding = PaddingValues(10.dp)
            )
            SSLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(Color.Blue)),
                type = ButtonType.ZOOM_IN_OUT_PROGRESS,
                onClick = {
                    zoomInOutState = ButtonStateList.LOADING
                },
                currentState = zoomInOutState,
                width = 370.dp, height = 50.dp, padding = PaddingValues(10.dp)
            )
            SSLoadingButton(
                Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(Color.Red)),
                type = ButtonType.CLOCK,
                onClick = {
                    clockState = ButtonStateList.LOADING
                },
                currentState = clockState,
                width = 370.dp, height = 50.dp,  padding = PaddingValues(10.dp)
            )

            SSLoadingButton(
                assetColor = Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(Color.Red)),
                type = ButtonType.ROUNDED_PROGRESS,
                onClick = {
                    roundedProgressState2 = ButtonStateList.LOADING
                },
                currentState = roundedProgressState2,
                width = 370.dp, height = 50.dp,  padding = PaddingValues(10.dp)
            )
            SSLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(2.dp,SolidColor(Color.Blue)),
                type = ButtonType.SPIRAL,
                onClick = {
                    spiralState = ButtonStateList.LOADING
                },
                currentState = spiralState,
                width = 900.dp, height = 50.dp,  padding = PaddingValues(10.dp)
            )
            //********************************************************************************//

        }
    }
}

@Composable
fun SSLoadingButton(
    assetColor: Color,
    buttonBorderStroke: BorderStroke? = null,
    type: ButtonType,
    onClick: () -> Unit,
    currentState: ButtonStateList,
    cornerRadius: Int = 20,
    width: Dp,
    height: Dp,
    durationMillis: Int = 1000,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    padding: PaddingValues = PaddingValues(0.dp)
) {
    var buttonWidth by remember { mutableStateOf(width) }
    var iconAlphaValue by remember { mutableStateOf(oneFloat) }
    val iconAlpha: Float by animateFloatAsState(iconAlphaValue, animationSpec = tween(durationMillis))
    var successIconAlphaValue by remember { mutableStateOf(zeroFloat) }
    val successIconAlpha: Float by animateFloatAsState(
        successIconAlphaValue,
        animationSpec = tween(1000)
    )
    var failureAlphaValue by remember { mutableStateOf(zeroFloat) }
    val failureAlpha: Float by animateFloatAsState(failureAlphaValue, animationSpec = tween(durationMillis))
    var progressAlphaValue by remember { mutableStateOf(zeroFloat) }
    val progressAlpha: Float by animateFloatAsState(progressAlphaValue, animationSpec = tween(durationMillis))
    var cornerRadiusValue by remember {
        mutableStateOf( cornerRadius)
    }
    val buttonCornerRadius by animateIntAsState(cornerRadiusValue, animationSpec = tween(durationMillis))

    when (currentState) {
        ButtonStateList.IDLE -> {
            buttonWidth = width
            iconAlphaValue = oneFloat
            failureAlphaValue = zeroFloat
            successIconAlphaValue = zeroFloat
            progressAlphaValue = zeroFloat
            cornerRadiusValue = cornerRadius
        }
        ButtonStateList.LOADING -> {
            buttonWidth = height
            iconAlphaValue = zeroFloat
            failureAlphaValue = zeroFloat
            successIconAlphaValue = zeroFloat
            progressAlphaValue = oneFloat
            cornerRadiusValue = 50
        }
        ButtonStateList.SUCCESS -> {
            buttonWidth = height
            iconAlphaValue = zeroFloat
            failureAlphaValue = zeroFloat
            successIconAlphaValue = oneFloat
            progressAlphaValue = zeroFloat
            cornerRadiusValue = 50
        }
        ButtonStateList.FAILIURE -> {
            LaunchedEffect(key1 = "animation", block = {
                buttonWidth = height
                successIconAlphaValue = zeroFloat
                iconAlphaValue = zeroFloat
                progressAlphaValue = zeroFloat
                failureAlphaValue = oneFloat
                cornerRadiusValue = 50
                delay(2000)
                buttonWidth = width
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
                .size(sizeAnimationMethod(width = buttonWidth, durationMillis = durationMillis * 2), height = height),
            enabled = enabled,
            elevation = elevation,
            shape = RoundedCornerShape(buttonCornerRadius),
            border = buttonBorderStroke,
            colors = colors
        ) {}

        //Button end...starting other component
        //IDLE State icon
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            modifier = Modifier.graphicsLayer(alpha = iconAlpha).size(height - 20.dp),
            tint = assetColor
        )
        //SUCCESS State icon
        Icon(
            imageVector = Icons.Default.Done,
            contentDescription = null,
            modifier = Modifier.graphicsLayer(alpha = successIconAlpha).size(height - 20.dp),
            tint = assetColor
        )
        //FAILIURE State icon
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            modifier = Modifier.graphicsLayer(alpha = failureAlpha).size(height - 20.dp),
            tint = assetColor
        )
        //LOADING State
        var effectiveInnerHeight = height
        buttonBorderStroke?.width?.let {
            effectiveInnerHeight = effectiveInnerHeight - it - it
        }

        printLoadingBar(type = type, progressAlpha = progressAlpha, assetColor = assetColor, height = effectiveInnerHeight, durationMillis = durationMillis)
    }
}

@Composable
fun printLoadingBar(type: ButtonType, progressAlpha: Float, assetColor: Color, height: Dp, durationMillis: Int) {
    when (type) {
        ButtonType.ROUNDED_PROGRESS -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .graphicsLayer(alpha = progressAlpha).size(height- 10.dp),
                color = assetColor,
                strokeWidth = 3.dp
            )
        }
        ButtonType.WHEEL -> {
            Icon(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(height - 10.dp)
                    .graphicsLayer { alpha = progressAlpha }
                    .rotate(progressRotationMethod(0f, 360f, 1500)),
                tint = assetColor
            )
        }
        ButtonType.ZOOM_IN_OUT_PROGRESS -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .graphicsLayer(alpha = progressAlpha)
                    .size(progressDpMethod(initialValue = height - 10.dp, targetValue = 10.dp, durationMillis = durationMillis + 500)),
                color = assetColor,
                strokeWidth = 3.dp
            )
        }
        ButtonType.CLOCK -> {
            Clock(modifier = Modifier
                .graphicsLayer { alpha = progressAlpha }, color = assetColor, height = height
            )
        }
        ButtonType.SPIRAL -> {
            Icon(
                painter = painterResource(id = R.drawable.spiral),
                contentDescription = null,
                modifier = Modifier
                    .size(height - 10.dp)
                    .graphicsLayer { alpha = progressAlpha }
                    .rotate(progressRotationMethod(initialValue = threeSixtyFloat, targetValue = zeroFloat, durationMillis = durationMillis + 500)),
                tint = assetColor
            )
        }
    }
}
@Composable
fun Clock(modifier: Modifier = Modifier, color: Color, height: Dp) {
    val progressRotation = progressRotationMethod(initialValue = zeroFloat, targetValue = oneFloat , durationMillis = 1080 )
    val progressHourRotation = progressRotationMethod(initialValue = zeroFloat, targetValue = oneFloat , durationMillis = 12960 )
    Canvas(modifier = modifier) {
        val middle = Offset(size.minDimension / 2, size.minDimension / 2)
        withTransform(
            {
                rotate(360 * progressRotation, middle)
            }, {
                drawLine(
                    strokeWidth = 6.dp.toPx(),
                    cap = StrokeCap.Round,
                    color = color,
                    start = middle,
                    end = Offset(size.minDimension / 2, (height/2 - 9.dp).toPx())
                )
            }
        )

        withTransform(
            {
                rotate(360 * progressHourRotation, middle)
            }, {
                drawLine(
                    strokeWidth = 6.dp.toPx(),
                    cap = StrokeCap.Round,
                    color = Color.Black,
                    start = middle,
                    end = Offset(size.minDimension / 2, (height/2 - 12.dp).toPx())
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSLoadingButtonAndroidTheme {
        Greeting()
    }
}

enum class ComponentState { Pressed, Released }
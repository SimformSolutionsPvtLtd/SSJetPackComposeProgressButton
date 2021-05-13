package com.simform.ssloadingbuttonandroid

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simform.ssloadingbuttonandroid.ui.theme.SSLoadingButtonAndroidTheme

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
    var visible by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //********************************************************************************//
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(initialAlpha = 0.4f),
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)),
        ) {
            Button(
                onClick = {
                    visible = !visible
                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                elevation = ButtonDefaults.elevation(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Red
                )
            ) {
                Text(text = "Button 1")
            }
        }
        //********************************************************************************//
        var widthSize by remember { mutableStateOf(375.dp) }
        var state by remember { mutableStateOf(true) }
        val width by animateDpAsState(
            targetValue = widthSize,
            tween(
                durationMillis = 3000,
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
        Button(
            onClick = {
                if (state) {
                    widthSize = 100.dp
                } else {
                    widthSize = 375.dp
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
        //********************************************************************************//
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
        val transition: Transition<ComponentState> = updateTransition(targetState = toState)
        val scale: Float by transition.animateFloat(
            transitionSpec = { spring(stiffness = 50f) }
        ) { state ->
            if (state == ComponentState.Pressed) 3f else 1f
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
                ComponentState.Pressed -> MaterialTheme.colors.primary
                ComponentState.Released -> if (useRed) Color.Red else MaterialTheme.colors.secondary
            }
        }
        Button(
            onClick = {
                useRed = !useRed
            },
            modifier = Modifier
                .padding(10.dp)
                .size((100 * scale).dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            toState = ComponentState.Pressed
                            tryAwaitRelease()
                            toState = ComponentState.Released
                        }
                    )
                },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = color,
                contentColor = Color.Blue
            ),
            border = BorderStroke(width = 2.dp, brush = SolidColor(Color.DarkGray)),
            shape = RoundedCornerShape(50)

        ) {
            Text(text = "")
        }



        //********************************************************************************//
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Red
            ),
            border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Blue)),
            shape = CutCornerShape(10.dp)
        ) {
            Text(text = "Button 5")
        }

        //********************************************************************************//
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Red
            ),
            border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Blue)),
            shape = CutCornerShape(10.dp)
        ) {
            Text(text = "Button 6")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        //********************************************************************************//
        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Red
            ),
            border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Blue)),
            shape = CutCornerShape(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
            Text(text = "Button 7")
        }

        //********************************************************************************//
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            elevation = ButtonDefaults.elevation()
        ) {
            Text(text = "Elevated Button")
        }

        //********************************************************************************//
        OutlinedButton(
            onClick = {

            },
            border = BorderStroke(1.dp, Color.Red),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Outlined")
        }

        //********************************************************************************//
        val horizontalGradient = Brush.horizontalGradient(
            colors = listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primaryVariant),
            0f,
            250f
        )

        Text(
            text = "Horizontal gradient",
            style = typography.body2.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = {})
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(brush = horizontalGradient)
                .padding(12.dp)
        )

        // Create variable verticalGradient and inside color property define top and bottom color
        val verticalGradient = Brush.verticalGradient(
            colors = listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primaryVariant),
            startY = 0f,
            endY = 100f
        )
        // Vertical gradient Button
        // Create a text and set its background to verticalGradient that we created above
        Text(
            text = "Vertical gradient",
            style = typography.body1.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = {})
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(brush = verticalGradient)
                .padding(12.dp)
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
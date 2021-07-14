package com.simform.ssloadingbuttonandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simform.ssloadingbuttonandroid.ssbutton.SSLoadingButton.ssLoadingButton
import com.simform.ssloadingbuttonandroid.ssbutton.SSButtonState
import com.simform.ssloadingbuttonandroid.ssbutton.SSButtonType
import com.simform.ssloadingbuttonandroid.utils.*
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedColorAnimation
import com.simform.ssloadingbuttonandroid.ssbutton.Animation.ssRepeatedFloatAnimation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    var roundedProgressState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var wheelState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var zoomInOutState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var clockState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var roundedProgressState2: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var spiralState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var ssTextButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithRightButton: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithIconState: SSButtonState by remember {
        mutableStateOf(SSButtonState.IDLE)
    }
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
                        roundedProgressState = SSButtonState.SUCCESS
                        wheelState = SSButtonState.SUCCESS
                        zoomInOutState = SSButtonState.SUCCESS
                        clockState = SSButtonState.SUCCESS
                        roundedProgressState2 = SSButtonState.SUCCESS
                        spiralState = SSButtonState.SUCCESS
                        ssTextButtonState = SSButtonState.SUCCESS
                        textWithIconState = SSButtonState.SUCCESS
                        textWithRightButton = SSButtonState.SUCCESS
                    },
                    modifier = Modifier.padding(six.dp),
                    elevation = ButtonDefaults.elevation()
                ) {
                    Text(text = stringResource(id = R.string.on_success))
                }
                Button(
                    onClick = {
                        roundedProgressState = SSButtonState.FAILIURE
                        wheelState = SSButtonState.FAILIURE
                        zoomInOutState = SSButtonState.FAILIURE
                        clockState = SSButtonState.FAILIURE
                        roundedProgressState2 = SSButtonState.FAILIURE
                        spiralState = SSButtonState.FAILIURE
                        ssTextButtonState = SSButtonState.FAILIURE
                        textWithIconState = SSButtonState.FAILIURE
                        textWithRightButton = SSButtonState.FAILIURE
                    },
                    modifier = Modifier.padding(six.dp),
                    elevation = ButtonDefaults.elevation()
                ) {
                    Text(text = stringResource(id = R.string.on_failure))
                }
            }
        }
        item {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(fifty)
            ) {
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer(
                            scaleX = ssRepeatedFloatAnimation(
                                oneFloat, oneHalfFloat,
                                thousand
                            ), scaleY = ssRepeatedFloatAnimation(
                                oneFloat, oneHalfFloat,
                                thousand
                            )
                        )
                        .padding(end = six.dp),
                    tint = ssRepeatedColorAnimation(Color.Red, Color.White, thousand)
                )
            }
            //**********************************SSLoadingButton Start from here ******************************************//
            ssLoadingButton(
                assetColor = Color.White,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Red)),
                type = SSButtonType.ROUNDED_PROGRESS,
                onClick = {
                    roundedProgressState = SSButtonState.LOADING
                },
                buttonState = roundedProgressState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            ssLoadingButton(
                assetColor = colorResource(id = R.color.dark_green),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(
                    two.dp,
                    SolidColor(colorResource(id = R.color.dark_green))
                ),
                type = SSButtonType.WHEEL,
                onClick = {
                    wheelState = SSButtonState.LOADING
                },
                buttonState = wheelState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            ssLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Blue)),
                type = SSButtonType.ZOOM_IN_OUT_PROGRESS,
                onClick = {
                    zoomInOutState = SSButtonState.LOADING
                },
                buttonState = zoomInOutState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            ssLoadingButton(
                Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Red)),
                type = SSButtonType.CLOCK,
                onClick = {
                    clockState = SSButtonState.LOADING
                },
                buttonState = clockState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )

            ssLoadingButton(
                assetColor = Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Red)),
                type = SSButtonType.ROUNDED_PROGRESS,
                onClick = {
                    roundedProgressState2 = SSButtonState.LOADING
                },
                buttonState = roundedProgressState2,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            ssLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Blue)),
                type = SSButtonType.SPIRAL,
                onClick = {
                    spiralState = SSButtonState.LOADING
                },
                buttonState = spiralState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            ssLoadingButton(
                assetColor = Color.White,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow)),
                buttonBorderStroke = BorderStroke(
                    two.dp,
                    SolidColor(colorResource(id = R.color.yellow))
                ),
                type = SSButtonType.ZOOM_IN_OUT_PROGRESS,
                onClick = {
                    ssTextButtonState = SSButtonState.LOADING
                },
                buttonState = ssTextButtonState,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                padding = PaddingValues(six.dp),
                text = stringResource(id = R.string.with_text),
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                textModifier = Modifier.padding(six.dp)
            )
            ssLoadingButton(
                assetColor = Color.White,
                type = SSButtonType.WHEEL,
                onClick = {
                    textWithIconState = SSButtonState.LOADING
                },
                buttonState = textWithIconState,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person),
                text = stringResource(id = R.string.left_icon)
            )

            ssLoadingButton(
                assetColor = Color.White,
                type = SSButtonType.SPIRAL,
                onClick = { textWithRightButton = SSButtonState.LOADING },
                buttonState = textWithRightButton,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                rightImagePainter = rememberVectorPainter(image = Icons.Default.Person),
                text = stringResource(id = R.string.right_icon),
                padding = PaddingValues(six.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700))
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting()
}
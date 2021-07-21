package com.simform.ssloadingbuttonandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simform.ssloadingbuttonandroid.utils.COMMON_HEIGHT
import com.simform.ssloadingbuttonandroid.utils.COMMON_WIDTH
import com.simform.ssloadingbuttonandroid.utils.forty
import com.simform.ssloadingbuttonandroid.utils.oneFloat
import com.simform.ssloadingbuttonandroid.utils.six
import com.simform.ssloadingbuttonandroid.utils.two
import com.simform.ssloadingbuttonandroid.utils.zero
import com.simform.ssloadingbuttonlibrary.SSButtonState
import com.simform.ssloadingbuttonlibrary.SSButtonType
import com.simform.ssloadingbuttonlibrary.SSLoadingButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSLoadingButtonExample()
        }
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
        //Two button at top for fire success and failure
        item {
            Row(
                Modifier
                    .padding(zero.dp, zero.dp, zero.dp, forty.dp)
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
                    },
                    modifier = Modifier
                        .padding(six.dp)
                        .weight(oneFloat),
                    elevation = ButtonDefaults.elevation(), colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_blue))
                ) {
                    Text(text = stringResource(id = R.string.on_success), color = Color.White )
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
                        blinkingIcon = SSButtonState.FAILIURE
                    },
                    modifier = Modifier
                        .padding(six.dp)
                        .weight(1f),
                    elevation = ButtonDefaults.elevation(), colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_blue))
                ) {
                    Text(text = stringResource(id = R.string.on_failure), color = Color.White)
                }
            }
        }
        //Various example of SSLoadingButton
        item {
            SSLoadingButton(
                assetColor = Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Red)),
                type = SSButtonType.CIRCLE,
                onClick = { roundedProgressState2 = SSButtonState.LOADING },
                buttonState = roundedProgressState2,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
            )
            SSLoadingButton(
                assetColor = colorResource(id = R.color.dark_green),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(
                    two.dp,
                    SolidColor(colorResource(id = R.color.dark_green))
                ),
                type = SSButtonType.WHEEL,
                onClick = { wheelState = SSButtonState.LOADING },
                buttonState = wheelState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
            )
            SSLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Blue)),
                type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                onClick = { zoomInOutState = SSButtonState.LOADING },
                buttonState = zoomInOutState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
            )
            SSLoadingButton(
                assetColor = Color.Red,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Red)),
                type = SSButtonType.CLOCK,
                onClick = { clockState = SSButtonState.LOADING },
                buttonState = clockState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
            )
            SSLoadingButton(
                assetColor = Color.Blue,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                buttonBorderStroke = BorderStroke(two.dp, SolidColor(Color.Blue)),
                type = SSButtonType.SPIRAL,
                onClick = { spiralState = SSButtonState.LOADING },
                buttonState = spiralState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
            )
            SSLoadingButton(
                assetColor = Color.White,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                type = SSButtonType.CIRCLE,
                onClick = { roundedProgressState = SSButtonState.LOADING },
                buttonState = roundedProgressState,
                width = COMMON_WIDTH.dp, height = COMMON_HEIGHT.dp, padding = PaddingValues(six.dp),
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
            )
            SSLoadingButton(
                assetColor = Color.Yellow,
                type = SSButtonType.CLOCK,
                onClick = { blinkingIcon = SSButtonState.LOADING },
                buttonState = blinkingIcon,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                blinkingIcon = true,
                leftImagePainter = rememberVectorPainter(image = Icons.Default.FavoriteBorder),
                padding = PaddingValues(six.dp),
                hourHandColor = Color.Red
            )
            SSLoadingButton(
                assetColor = Color.White,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow)),
                buttonBorderStroke = BorderStroke(
                    two.dp,
                    SolidColor(colorResource(id = R.color.yellow))
                ),
                type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                onClick = { ssTextButtonState = SSButtonState.LOADING },
                buttonState = ssTextButtonState,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                padding = PaddingValues(six.dp),
                text = stringResource(id = R.string.with_text),
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                textModifier = Modifier.padding(six.dp),
            )
            SSLoadingButton(
                assetColor = Color.White,
                type = SSButtonType.WHEEL,
                onClick = { textWithIconState = SSButtonState.LOADING },
                buttonState = textWithIconState,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                leftImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                text = stringResource(id = R.string.left_icon),
                fontFamily = FontFamily.SansSerif,
                textModifier = Modifier.padding(six.dp),
                blinkingIcon = true,
                padding = PaddingValues(six.dp),
                colors = ButtonDefaults.buttonColors( backgroundColor = colorResource(id = R.color.light_blue))
            )
            SSLoadingButton(
                assetColor = Color.White,
                type = SSButtonType.SPIRAL,
                onClick = { textWithRightButton = SSButtonState.LOADING },
                buttonState = textWithRightButton,
                width = COMMON_WIDTH.dp,
                height = COMMON_HEIGHT.dp,
                rightImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                text = stringResource(id = R.string.right_icon),
                fontFamily = FontFamily.Serif,
                textModifier = Modifier.padding(six.dp),
                padding = PaddingValues(six.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_700))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSLoadingButtonExample()
}